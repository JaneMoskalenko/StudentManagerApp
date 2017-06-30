package com.example.admin.studentmanager.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.example.admin.studentmanager.R;

/**
 * Created by admin on 24.06.2017.
 */

public class StudentListActivity extends Activity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private EditText edtStudentListUpdate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
        /*setUpRecyclerView("");

        edtStudentListUpdate = (EditText) findViewById(R.id.edtStudentListUpdate);
        edtStudentListUpdate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setUpRecyclerView(edtStudentListUpdate.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                setUpRecyclerView(edtStudentListUpdate.getText().toString());
            }
        });
    }*/

   /* private void setUpRecyclerView(String studentName) {
        StudentRecyclerViewAdapter adapter = new StudentRecyclerViewAdapter(this, Student.getData(studentName), this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);
    }
*/

}
