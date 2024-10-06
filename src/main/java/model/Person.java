package model;


import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


public class Person {
    private int id;
    private String first_name;
    private String last_name;
    private LocalDate birthDate;
    private String nationalCode;
    private String phoneNumber;


    public Person() {
    }

    public Person(String first_name, String nationalCode) {
        this.first_name = first_name;
        this.nationalCode = nationalCode;
    }

    public Person(int id, String first_name, String last_name, String nationalCode) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nationalCode = nationalCode;
    }

    public Person(String first_name, String last_name, String nationalCode) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nationalCode = nationalCode;
    }

    public Person(String first_name, String last_name, String nationalCode, String phoneNumber) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
    }

    public Person(String first_name, String last_name, LocalDate birthDate, String nationalCode, String phoneNumber) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
    }

    public Person(int id, String first_name, String last_name, LocalDate birthDate, String nationalCode, String phoneNumber) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(first_name, person.first_name) && Objects.equals(last_name, person.last_name) && Objects.equals(birthDate, person.birthDate) && Objects.equals(nationalCode, person.nationalCode) && Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, birthDate, nationalCode, phoneNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birthDate=" + birthDate +
                ", nationalCode='" + nationalCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
