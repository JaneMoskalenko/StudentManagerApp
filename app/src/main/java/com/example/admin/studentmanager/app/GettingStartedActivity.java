package com.example.admin.studentmanager.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.manager.GroupManager;
import com.example.admin.studentmanager.manager.LessonManager;
import com.example.admin.studentmanager.manager.StudentManager;
import com.example.admin.studentmanager.manager.SubjectManager;

/**
 * Created by admin on 24.06.2017.
 */

public class GettingStartedActivity extends Activity {
    private static final String TAG = GettingStartedActivity.class.getSimpleName();
    private TextView tvHello;
    private Button btnViewGroupList, btnViewLessonList, btnViewStudentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);

        StringBuilder msg = new StringBuilder("Добро пожаловать, \n");
        Intent intent = getIntent();
        String name = intent.getStringExtra("login");
        msg.append(name).append(" !");

        btnViewGroupList = (Button) findViewById(R.id.btnViewGroupList);
        btnViewStudentList = (Button) findViewById(R.id.btnViewStudentList);
        btnViewLessonList = (Button) findViewById(R.id.btnViewLessonList);

        tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText(msg);

        btnViewGroupList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GettingStartedActivity.this, GroupListActivity.class);
                startActivity(intent);
            }
        });

        btnViewStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GettingStartedActivity.this, StudentListActivity.class);
                startActivity(intent);
            }
        });

        btnViewLessonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GettingStartedActivity.this, LessonListActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        GroupManager groupManager = new GroupManager();
        StudentManager studentManager = new StudentManager();
        SubjectManager subjectManager = new SubjectManager();
        LessonManager lessonManager = new LessonManager();

    }
}
