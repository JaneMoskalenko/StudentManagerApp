package com.example.admin.studentmanager.manager;

import android.util.Log;

import com.example.admin.studentmanager.model.DummyType;
import com.example.admin.studentmanager.model.Group;
import com.example.admin.studentmanager.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.example.admin.studentmanager.manager.GroupManager.sGroups;

/**
 * Created by admin on 25.06.2017.
 */

public class StudentManager {
    public static int StudentFirstNamesLength = DummyType.FIRSTNAMES.length;
    public static HashMap<Long, Student> sStudents = new HashMap<>();
    private static final String TAG = "StudentManager";

    public StudentManager() {
        for (int i=0; i< StudentFirstNamesLength; i++) {
            Student student = addDummyStudent();
            sStudents.put(student.getId(), student);
            Log.d(TAG, " on init Dummy student " + student.getGroupID() );
        }
        Log.d(TAG, " after initial Dummy students " + sStudents.keySet().size() + "  " + sStudents.size());

    }

    private static Student createUser(String name, String firstName, String surname, Date dateOfBirth, Long groupID, int imageID) {
        Student student = new Student(name, firstName, surname, dateOfBirth, groupID, imageID);
        return student;
    }

    public static Student addDummyStudent() {
        Random random = new Random();
        int indexFName = random.nextInt(StudentFirstNamesLength);
        int indexMName = random.nextInt(DummyType.MIDDLENAMES.length);
        int indexLName = random.nextInt(DummyType.LASTNAMES.length);
        int indexGroup =  random.nextInt(sGroups.keySet().size());
        Long groupID = 0L;

        int i=0;
        for (Map.Entry<Long, Group> entry: sGroups.entrySet()) {
            if (i==indexGroup) groupID = entry.getKey();
            i++;
        }

       Log.d(TAG, " on create Dummy student " + groupID + "  " + sGroups.keySet().size());

        Student student;
        student = createUser(DummyType.FIRSTNAMES[indexFName],
                DummyType.MIDDLENAMES[indexMName] ,
                DummyType.LASTNAMES[indexLName],
                new Date(),
                groupID,
                DummyType.getRandomImage());

        return student;
    }

    public int getStudentsSize(){
        return sStudents.size();
    }

    public static ArrayList<Student> getStudentsByGroupID (Long groupID) {
        ArrayList<Student> dataList = new ArrayList<>();
        Student student;
        for (Map.Entry<Long, Student> entry: sStudents.entrySet()) {
            student = entry.getValue();
            if (groupID != null) {
                if (student.getGroupID().equals(groupID)) {
                    Log.d(TAG, " on getting Dummy student by group " + student.getImageID() + "  " + student.getName());
                    dataList.add(student);
                }
            }
            else { dataList.add(student);}
        }
        return dataList;
    }

    public static ArrayList<Student> getStudentsByFIO (String studentName) {
        ArrayList<Student> dataList = new ArrayList<>();
        Student student;
        for (Map.Entry<Long, Student> entry: sStudents.entrySet()) {
            student = entry.getValue();
            if ((student.getName().contains(studentName))||(student.getFirstName().contains(studentName))) {
                    dataList.add(student);
            }
        }
        return dataList;
    }

    public static Student getStudentNameByID(Long StudentID) {
        Student student;
        student = sStudents.get(StudentID);
        return student;
    }
    
}
