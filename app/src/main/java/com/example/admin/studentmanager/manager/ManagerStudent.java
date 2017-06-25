package com.example.admin.studentmanager.manager;

import com.example.admin.studentmanager.model.DummyType;
import com.example.admin.studentmanager.model.Student;

import java.util.Date;
import java.util.Random;

import static com.example.admin.studentmanager.manager.GroupManager.sGroups;

/**
 * Created by admin on 25.06.2017.
 */

public class ManagerStudent {

    private static Student createUser(String name, String firstName, String surname, Date dateOfBirth, Long groupID, int imageID) {
        Student student = new Student(name, firstName, surname, dateOfBirth, groupID, imageID);
        return student;
    }

    public static Student addDummyStudent(int imageID) {
        Random random = new Random();
        int indexFName = random.nextInt(DummyType.FIRSTNAMES.length);
        int indexMName = random.nextInt(DummyType.MIDDLENAMES.length);
        int indexLName = random.nextInt(DummyType.LASTNAMES.length);
        int indexGroup =  random.nextInt(sGroups.size());

        Student student;
        student = createUser(DummyType.FIRSTNAMES[indexFName],
                DummyType.MIDDLENAMES[indexMName] ,
                DummyType.LASTNAMES[indexLName],
                new Date(),
                (long) indexGroup, imageID);
            //    sGroups.get(indexGroup).getId(), imageID);
        return student;
    }
    
}
