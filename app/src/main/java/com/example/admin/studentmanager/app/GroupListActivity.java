package com.example.admin.studentmanager.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.admin.studentmanager.OnListItemCallback;
import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.adapter.GroupRecyclerViewAdapter;
import com.example.admin.studentmanager.manager.GroupManager;
import com.example.admin.studentmanager.model.Group;
import com.example.admin.studentmanager.model.Lesson;
import com.example.admin.studentmanager.model.Student;

/**
 * Created by admin on 24.06.2017.
 */

public class GroupListActivity extends AppCompatActivity implements OnListItemCallback {
    EditText edt_group_name;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        edt_group_name = (EditText) findViewById(R.id.edtGroupListUpdate);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        setUpRecyclerView("");

        edt_group_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setUpRecyclerView(edt_group_name.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                setUpRecyclerView(edt_group_name.getText().toString());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("groupName", edt_group_name.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        edt_group_name.setText(savedInstanceState.getString("groupName"));
    }

    private void setUpRecyclerView(String groupName) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GroupRecyclerViewAdapter adapter = new GroupRecyclerViewAdapter(this, GroupManager.getGroupsByName(groupName), this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onClick(Group group) {
       // Toast.makeText(this, "Item selected "+ group.getGroupName(), Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(GroupListActivity.this, GroupProfileActivity.class);

        intent.putExtra("groupID", group.getId());
        startActivity(intent);
    }

    @Override
    public void onClick(Student student) {
    }

    @Override
    public void onClick(Lesson lesson) {

    }
}
