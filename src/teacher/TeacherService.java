package teacher;

import common.Database;
import common.RegistrationServiceInterface;

import java.io.Serializable;
import java.util.Scanner;

public class TeacherService implements RegistrationServiceInterface {

    @Override
    public void showMenu() {
        System.out.println("1- Siahiya baxin: \n" +
                "2- Qeydiyattad kecirin: \n" +
                "3- Deyisiklik etmek; \n" +
                "4- Silmek ucun; \n");

        int operation = new Scanner(System.in).nextInt();
        if (operation == 1) {
            this.showAll();
        } else if (operation == 2) {
            this.register();
        } else if (operation == 3) {
            this.update();
            ;
        } else if (operation == 4) {
            this.delete();
        } else {
            System.out.println("secim yalnisdir");
        }
    }

    @Override
    public void register() {
        Teacher[] longerArr = new Teacher[Database.db.teachers.length + 1];
        for (int i = 0; i < Database.db.teachers.length; i++) {
            longerArr[i] = Database.db.teachers[i];
        }
        Teacher newTeacher = createAndFillTeacher();
        longerArr[longerArr.length - 1] = newTeacher;
        Database.db.teachers = longerArr;
    }

    @Override
    public void showAll() {
        if (Database.db.teachers == null) {
            System.out.println("Siyahi bosdur....");
        } else {
            for (int i = 0; i < Database.db.teachers.length; i++) {
                System.out.println(Database.db.teachers[i]);
            }
        }
    }

    @Override
    public void update() {
        System.out.println("Hansi muellimi deyismek isteyirsiiz:");
        showAll();
        int numb = new Scanner(System.in).nextInt();
        Teacher selectedteacher = Database.db.teachers[numb];
        askAndFill(selectedteacher);
    }

    @Override
    public void delete() {
        System.out.println("Sileceyiniz muelliomi secin:  ");
        showAll();

        int numb = new Scanner(System.in).nextInt();
        int index = numb - 1;

        Teacher[] deletedTeacher = new Teacher[Database.db.teachers.length - 1];

        int j = 0;

        for (int i = 0; i < Database.db.teachers.length; i++) {
            if (i == index) {
                continue;
            }

            deletedTeacher[j] = Database.db.teachers[i];
            j++;
        }

        Database.db.teachers = deletedTeacher;
    }

    private Teacher askAndFill(Teacher t) {
        System.out.println("Ad daxil edin:");
        t.setName(new Scanner(System.in).nextLine());

        System.out.println("Soyad daxil edin:");
        t.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Yas daxil edin:");
        t.setAge(new Scanner(System.in).nextInt());

        System.out.println("Maas daxil edin:");
        t.setSalary(new Scanner(System.in).nextBigDecimal());

        return t;
    }

    private Teacher createAndFillTeacher() {
        Teacher teacher = new Teacher();
        askAndFill(teacher);
        return teacher;
    }
}
