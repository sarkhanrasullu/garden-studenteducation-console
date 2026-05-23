import common.RegistrationServiceFactory;
import common.RegistrationServiceInterface;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        while (true) {
            System.out.println("Hansi xidmeti secmek isteyirsiniz: 1-Teacher, 2-Student, 3-Exit");
            int input = new Scanner(System.in).nextInt();

            RegistrationServiceInterface service = RegistrationServiceFactory.getInstance(input);

            if(service == null) {
                System.out.println("Yalnis secim etdiniz, yeniden cehd edin...");
                continue;
            }

            service.showMenu();
        }

    }


}
