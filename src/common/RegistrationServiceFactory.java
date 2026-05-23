package common;

import student.RegistrationServiceProxy;
import student.StudentService;
import teacher.TeacherService;

public class RegistrationServiceFactory {

    public static RegistrationServiceInterface getInstance(int input) {
        if (input == 1) {
            return new RegistrationServiceProxy(new TeacherService());
        } else if (input == 2) {
            return new RegistrationServiceProxy(new StudentService());
        } else {
            return null;
        }
    }
}
