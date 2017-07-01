package com.example.admin.studentmanager.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.studentmanager.OnListItemCallback;
import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.adapter.StudentRecyclerViewAdapter;
import com.example.admin.studentmanager.app.Student.StudentProfileActivity;
import com.example.admin.studentmanager.manager.StudentManager;
import com.example.admin.studentmanager.model.Group;
import com.example.admin.studentmanager.model.Lesson;
import com.example.admin.studentmanager.model.Student;

import java.util.ArrayList;

import static com.example.admin.studentmanager.manager.GroupManager.getGroupNameByID;

/**
 * Created by admin on 28.06.2017.
 */

public class GroupProfileActivity extends Activity implements OnListItemCallback {
    private static final String TAG = "GroupProfile ";
    private RecyclerView recyclerView;
    private TextView tv_groupID;
    private EditText edtStudentListUpdate;
    private Long groupID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);
        tv_groupID = (TextView) findViewById(R.id.tv_groupID);
        Fragment fragment = getFragmentManager().findFragmentById(R.id.frStudentList);

        Intent intent = getIntent();
        groupID = intent.getLongExtra("groupID", 0L);

        tv_groupID.setText(tv_groupID.getText().toString() + getGroupNameByID(groupID) );

        edtStudentListUpdate = (EditText) findViewById(R.id.edtStudentListUpdate);
        edtStudentListUpdate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setUpRecyclerView(StudentManager.getStudentsByFIO(edtStudentListUpdate.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
                setUpRecyclerView(StudentManager.getStudentsByFIO(edtStudentListUpdate.getText().toString()));
            }
        });

        recyclerView = (RecyclerView) fragment.getView().findViewById(R.id.recyclerView);
        setUpRecyclerView(StudentManager.getStudentsByGroupID(groupID));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("studentName", edtStudentListUpdate.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        edtStudentListUpdate.setText(savedInstanceState.getString("studentName"));
    }

    private void setUpRecyclerView(ArrayList<Student> dataList) {
        StudentRecyclerViewAdapter adapter = new StudentRecyclerViewAdapter(this,dataList, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);

    }

    @Override
    public void onClick(Student student) {
        Toast.makeText(this, "Item selected "+ student.getName(), Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(GroupProfileActivity.this, StudentProfileActivity.class);

        intent.putExtra("studentID", student.getId());
        startActivity(intent);

    }

    @Override
    public void onClick(Group group) {
    }

    @Override
    public void onClick(Lesson lesson) {
    }
}
