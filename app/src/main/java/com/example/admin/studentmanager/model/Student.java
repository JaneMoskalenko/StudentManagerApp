package com.example.admin.studentmanager.model;

import com.example.admin.studentmanager.manager.ManagerStudent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by admin on 08.06.2017.
 */
public class Student implements Serializable {
    private final Long id;
    private String name;
    private String firstName;
    private String surname;
    private Date dateOfBirth;
    private Long groupID;
    private int imageID;
    private List<Contact> contacts;

    public Student(String name, String firstName, String surname, Date dateOfBirth, Long groupID) {
        this.name = name;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.groupID = groupID;
        this.id=System.currentTimeMillis();
        this.contacts = new ArrayList<>();
    }

    public Student(String name, String firstName, String surname, Date dateOfBirth, Long groupID, int imageID) {
        this.name = name;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.groupID = groupID;
        this.imageID = imageID;
        this.id=System.currentTimeMillis();
        this.contacts = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }


    public static ArrayList<Student> getData(){
        ArrayList<Student> dataList = new ArrayList<>();
        int [] images =DummyType.getImages();

        for (int i=0; i< DummyType.FIRSTNAMES.length; i++) {
            Student student = ManagerStudent.addDummyStudent(images[i]);
            dataList.add(student);
        }
        return dataList;
    }

    @Override
    public int hashCode() {
        return (int) (21+id*42);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Student)) return false;
        if (this.id != ((Student) obj).getId()) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("About this student: \n")
                .append("\tLast name: ").append(getSurname()).append("\n")
                .append("\tFirst name: ").append(getName()).append("\n")
                .append("\tMiddle name: ").append(getFirstName()).append("\n")
                .append("\tDate of birth: ").append(getDateOfBirth()).append("\n")
                .append("\tID: ").append(getId()).append("\n")
                .append("\tGroup number: ").append(getGroupID()).append("\n");
        return stringBuilder.toString();
    }
}
