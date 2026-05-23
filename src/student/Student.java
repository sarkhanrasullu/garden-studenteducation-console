package student;

import common.University;

import java.math.BigDecimal;

public final class Student {

    private final String name;
    private final String surname;
    private final Integer age;
    private final BigDecimal scholarship;
    private final University university;

    public Student(String name, String surname, Integer age, BigDecimal scholarship, University university) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.scholarship = scholarship;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public University getUniversity() {
        return new University(university.getName());
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + age + " " + scholarship;
    }
}
