package common;

import student.Student;
import teacher.Teacher;

import java.io.Serializable;

public final class Database implements Serializable {

    public Student[] students = new Student[0];
    public Teacher[] teachers = new Teacher[0];

    private Database() {

    }

    public static final Database db = new Database();

}
