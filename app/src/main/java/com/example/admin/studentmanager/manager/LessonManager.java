package com.example.admin.studentmanager.manager;

import android.util.Log;

import com.example.admin.studentmanager.model.DummyType;
import com.example.admin.studentmanager.model.Lesson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.example.admin.studentmanager.manager.GroupManager.getRandomGroupID;
import static com.example.admin.studentmanager.manager.SubjectManager.getRandomSubjectID;
import static com.example.admin.studentmanager.manager.SubjectManager.subjectNameLength;

/**
 * Created by admin on 30.06.2017.
 */

public class LessonManager {
    public static int lessonNameLength = DummyType.LESSONNAMES.length;
    public static int lectorNameLength = DummyType.LECTORNAMES.length;
    public static HashMap<Long, Lesson> sLessons = new HashMap<>();
    private static final String TAG = "LessonManager";

    public LessonManager() {
        for (int i = 0; i < lessonNameLength; i++) {
            Lesson lesson = createDummyLesson();
            sLessons.put(lesson.getId(), lesson);
            Log.d(TAG, " on init Dummy subject " + lesson.getId() + "  " + lesson.getName());
        }
    }

    public static int  getLessonSize() {
        return sLessons.size();
    }

    public static Lesson createDummyLesson() {
        Log.d(TAG, " on create Dummy lesson " + DummyType.SUBJECTNAMES[getRandomNumberOfLesson()] + "  " + subjectNameLength);
        return new Lesson(DummyType.LESSONNAMES[getRandomNumberOfLesson()],
                new Date(), new Date(), "501", "Описание занятия",
                getRandomSubjectID(),
                DummyType.LECTORNAMES[getRandomNumberOfLector()],
                getRandomGroupID());
    }

    private static int getRandomNumberOfLesson(){
        Random random = new Random();
        return random.nextInt(lessonNameLength);
    }

    private static int getRandomNumberOfLector(){
        Random random = new Random();
        return random.nextInt(lectorNameLength);
    }

    public static ArrayList<Lesson> getLessonsByName(String lessonName) {
        ArrayList<Lesson> dataList = new ArrayList<>();
        Lesson lesson;
        for (Map.Entry<Long, Lesson> entry : sLessons.entrySet()) {
            lesson = entry.getValue();
            if (lesson.getName().contains(lessonName)) {
                System.out.println(entry.getKey() + " = " + lesson.getId() + " " + lesson.getName());
                dataList.add(lesson);
            }
        }
        return dataList;
    }

    private static Lesson prepareNewLesson(String name, Date dateBegin, Date dateEnd,
                                      String auditorium, String description)  {
        Log.d(TAG, " on add new lesson " + DummyType.SUBJECTNAMES[getRandomNumberOfLesson()] + "  " + subjectNameLength);
        return new Lesson(name,
                dateBegin, dateEnd, auditorium, description,
                getRandomSubjectID(),
                DummyType.LECTORNAMES[getRandomNumberOfLector()],
                getRandomGroupID());
    }

    public static boolean addNewLesson(String name, Date dateBegin, Date dateEnd,
                                String auditorium, String description) {
        Lesson lesson = prepareNewLesson(name, dateBegin, dateEnd, auditorium, description);
        if (lesson != null) {
            sLessons.put(lesson.getId(), lesson);
            return true;
        }
        else return false;
    }

}
