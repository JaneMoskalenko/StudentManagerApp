package com.example.admin.studentmanager.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.studentmanager.OnListItemCallback;
import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.adapter.GroupRecyclerViewAdapter;
import com.example.admin.studentmanager.adapter.LessonRecyclerViewAdapter;
import com.example.admin.studentmanager.manager.GroupManager;
import com.example.admin.studentmanager.manager.LessonManager;
import com.example.admin.studentmanager.model.Group;
import com.example.admin.studentmanager.model.Lesson;
import com.example.admin.studentmanager.model.Student;

/**
 * Created by admin on 24.06.2017.
 */

public class LessonListActivity extends Activity implements OnListItemCallback {
    EditText edtLessonListUpdate;
    RecyclerView recyclerView;
    Button btn_add_lesson;
    private Long lessonID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_fragmentl);
        Fragment fragment = getFragmentManager().findFragmentById(R.id.frLessonList);

        Intent intent = getIntent();
        lessonID = intent.getLongExtra("lessonID", 0L);

        edtLessonListUpdate = (EditText) findViewById(R.id.edtLessonListUpdate);
        btn_add_lesson = (Button) findViewById(R.id.btn_add_lesson);

        btn_add_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonListActivity.this, AddLessonActivity.class);
                startActivity(intent);
            }
        });

       /* edtLessonListUpdate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setUpRecyclerView(edtLessonListUpdate.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                setUpRecyclerView(edtLessonListUpdate.getText().toString());
            }
        });*/

        recyclerView = (RecyclerView) fragment.getView().findViewById(R.id.recyclerView);
        setUpRecyclerView("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("lessonName", edtLessonListUpdate.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        edtLessonListUpdate.setText(savedInstanceState.getString("lessonName"));
    }

    private void setUpRecyclerView(String groupName) {
        LessonRecyclerViewAdapter adapter = new LessonRecyclerViewAdapter(this, LessonManager.getLessonsByName(groupName), this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);
    }


    @Override
    public void onClick(Lesson lesson) {
        Toast.makeText(this, "Selected " + lesson.getName(), Toast.LENGTH_LONG).show();
        /*Intent intent= new Intent(LessonListActivity.this, GroupProfileActivity.class);
        intent.putExtra("LessonID", lesson.getId());
        startActivity(intent);*/
    }


    @Override
    public void onClick(Group group) {
    }

    @Override
    public void onClick(Student student) {
    }


}
