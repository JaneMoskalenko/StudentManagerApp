package com.example.admin.studentmanager;

import com.example.admin.studentmanager.model.Group;
import com.example.admin.studentmanager.model.Lesson;
import com.example.admin.studentmanager.model.Student;

/**
 * Created by admin on 28.06.2017.
 */

public interface OnListItemCallback {

     void onClick(Group group);

     void onClick(Student student);

     void onClick(Lesson lesson);
}
