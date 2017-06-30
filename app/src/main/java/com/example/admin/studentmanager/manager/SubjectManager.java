package com.example.admin.studentmanager.manager;

import android.util.Log;

import com.example.admin.studentmanager.model.DummyType;
import com.example.admin.studentmanager.model.Group;
import com.example.admin.studentmanager.model.Lesson;
import com.example.admin.studentmanager.model.Subject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by admin on 30.06.2017.
 */

public class SubjectManager {
    public static int subjectNameLength = DummyType.SUBJECTNAMES.length;
    public static HashMap<Long, Subject> sSubject = new HashMap<>();
    private static final String TAG = "SubjectManager";

    public SubjectManager() {
        for (int i = 0; i < subjectNameLength; i++) {
            Subject subject = createDummySubject();
            sSubject.put(subject.getId(), subject);
            Log.d(TAG, " on init Dummy subject " + subject.getId() + "  " + subject.getSubjectName());
        }
    }

    public static Subject createDummySubject() {
        Log.d(TAG, " on create Dummy subject " + DummyType.SUBJECTNAMES[getRandomNumberOfSubject()] + "  " + subjectNameLength);
        return new Subject(DummyType.SUBJECTNAMES[getRandomNumberOfSubject()]);
    }

    private static int getRandomNumberOfSubject(){
        Random random = new Random();
        return random.nextInt(subjectNameLength);
    }

    public static Long getRandomSubjectID() {
        int i = 0;
        int random = getRandomNumberOfSubject();
        Long ID = 0L;
        for (Map.Entry<Long, Subject> entry : sSubject.entrySet()) {
            if (i == random) ID =  entry.getKey();
            i++;
        }
        return ID;
    }

}
