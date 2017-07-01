package com.example.admin.studentmanager.app.Student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.manager.StudentManager;
import com.example.admin.studentmanager.model.Student;

import java.security.AccessControlContext;

import static com.example.admin.studentmanager.manager.StudentManager.getStudentNameByID;

/**
 * Created by admin on 29.06.2017.
 */

public class StudentProfileActivity extends Activity {
    private Long studentID;
    TextView tv_student_firstname;
    TextView tv_student_name;
    TextView tv_student_surname;
    Button btn_student_edit;
    Button btn_student_group;
    Button btn_student_delete;
    Student student;
    ImageView student_photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        tv_student_firstname = (TextView) findViewById(R.id.tv_student_firstname);
        tv_student_name = (TextView) findViewById(R.id.tv_student_name);
        tv_student_surname = (TextView) findViewById(R.id.tv_student_surname);
        btn_student_edit = (Button) findViewById(R.id.btn_student_edit);
        btn_student_group = (Button) findViewById(R.id.btn_student_group);
        btn_student_delete = (Button) findViewById(R.id.btn_student_delete);

        Intent intent = getIntent();
        studentID = intent.getLongExtra("studentID", 0L);
        student = getStudentNameByID(studentID);

        student_photo = (ImageView) findViewById(R.id.student_photo);
        student_photo.setImageResource(student.getImageID());

        tv_student_firstname.setText(student.getFirstName());
        tv_student_name.setText(student.getName());
        tv_student_surname.setText(student.getSurname());

    }


}
