package student;

import common.Database;
import common.RegistrationServiceInterface;
import teacher.Teacher;

import java.util.Scanner;

public class StudentService implements RegistrationServiceInterface {

    @Override
    public void showMenu() {
        System.out.println("1- Siahiya baxin: \n" +
                "2- Qeydiyattad kecirin: \n" +
                "3- Deyisiklik etmek; \n" +
                "4- Silmek ucun; \n" +
                "5- Telebeye muellim teyin edin");

        int operation = new Scanner(System.in).nextInt();
        if (operation == 1) {
            this.showAll();
        } else if (operation == 2) {
            this.register();
        } else if (operation == 3) {
            this.update();
        } else if (operation == 4) {
            this.delete();
        } else if (operation == 5) {
            assign();
        } else {
            System.out.println("secim yalnisdir");
        }
    }

    @Override
    public void register() {
        Student[] longerArr = new Student[Database.db.students.length + 1];

        for (int i = 0; i < Database.db.students.length; i++) {
            longerArr[i] = Database.db.students[i];
        }

        Student newStudent = createAndFillStudent();

        longerArr[longerArr.length - 1] = newStudent;

        Database.db.students = longerArr;
    }

    @Override
    public void showAll() {
        if (Database.db.students == null) {
            System.out.println("Siyahi bosdur: ");
        } else
            for (int i = 0; i < Database.db.students.length; i++) {
                System.out.println(Database.db.students[i]);
            }
    }

    @Override
    public void update() {
        System.out.println("Hansi telebeni deyismek isteyirsiiz:");
        showAll();
        int numb = new Scanner(System.in).nextInt();
        Student selectedStudent = Database.db.students[numb];
        askAndFill(selectedStudent);
    }

    @Override
    public void delete() {
        System.out.println("Sileceyiniz telebeni secin:  ");
        showAll();

        int numb = new Scanner(System.in).nextInt();
        int index = numb - 1;

        Student[] deletedStudent = new Student[Database.db.students.length - 1];

        int j = 0;

        for (int i = 0; i < Database.db.students.length; i++) {
            if (i == index) {
                continue;
            }

            deletedStudent[j] = Database.db.students[i];
            j++;
        }

        Database.db.students = deletedStudent;
    }

    public void assign() {
        System.out.println("Telebe secin:");
        showAll();
        Student selectedStudent =  Database.db.students[new Scanner(System.in).nextInt()];

        System.out.println("Muellim secin:");
        for (int i = 0; i < Database.db.teachers.length; i++) {
            System.out.println(i + ". " + Database.db.teachers[i]);
        }
        Teacher selectedTeacher =  Database.db.teachers[new Scanner(System.in).nextInt()];

        selectedTeacher.assignStudent(selectedStudent);
    }

    private Student askAndFill(Student s) {
        System.out.println("Ad daxil edin:");
//        s.setName(new Scanner(System.in).nextLine());
//
//        System.out.println("Soyad daxil edin:");
//        s.setSurname(new Scanner(System.in).nextLine());
//
//        System.out.println("Yas daxil edin:");
//        s.setAge(new Scanner(System.in).nextInt());
//
//        System.out.println("Maas daxil edin:");
//        s.setScholarship(new Scanner(System.in).nextBigDecimal());

        return s;
    }

    private Student createAndFillStudent() {
        Student student = new Student();
        askAndFill(student);

        return student;
    }

}

