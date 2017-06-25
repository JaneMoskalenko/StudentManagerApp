package com.example.admin.studentmanager.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.adapter.RecyclerAdapterGroupList;
import com.example.admin.studentmanager.adapter.RecyclerAdapterStudentList;
import com.example.admin.studentmanager.model.Group;
import com.example.admin.studentmanager.model.Student;

/**
 * Created by admin on 24.06.2017.
 */

public class StudentListActivity extends Activity implements Toolbar.OnMenuItemClickListener {
    private Toolbar toolbar;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Менеджер студентов");
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        RecyclerAdapterStudentList adapter = new RecyclerAdapterStudentList(this, Student.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id =  item.getItemId();
        switch (id){
            case R.id.linearViewHorizontal:
                LinearLayoutManager mlinearLayoutManagerH = new LinearLayoutManager(this);
                mlinearLayoutManagerH.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mlinearLayoutManagerH);
                break;

            case R.id.linearViewVertical:
                LinearLayoutManager mlinearLayoutManagerV = new LinearLayoutManager(this);
                mlinearLayoutManagerV.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mlinearLayoutManagerV);
                break;

            case R.id.gridView:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                recyclerView.setLayoutManager(gridLayoutManager);
                break;

            case R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager staggeredGridLayoutManagerH = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManagerH);
                break;

            case R.id.staggeredViewVertical:
                StaggeredGridLayoutManager staggeredGridLayoutManagerV = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManagerV);
                break;
        }

        return true;
    }
}
