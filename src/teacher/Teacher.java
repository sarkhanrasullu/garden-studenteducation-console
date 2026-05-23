package teacher;

import common.Database;
import student.Student;

import java.math.BigDecimal;
import java.util.Arrays;

public class Teacher {
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;

    private Student[] students = new Student[0];

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher() {

    }

    public Teacher(String name, String surname, Integer age, BigDecimal salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void assignStudent(Student selectedStudent) {
        Student[] longerArr = new Student[this.students.length + 1];

        for (int i = 0; i < this.students.length; i++) {
            longerArr[i] = this.students[i];
        }

        longerArr[longerArr.length - 1] = selectedStudent;

        this.students = longerArr;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + age + " " + salary+"\n telebeler:"+ Arrays.toString(this.students);
    }
}
