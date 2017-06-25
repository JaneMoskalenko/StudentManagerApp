package com.example.admin.studentmanager.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.adapter.RecyclerAdapterGroupList;
import com.example.admin.studentmanager.model.Group;

/**
 * Created by admin on 24.06.2017.
 */

public class GroupListActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapterGroupList adapter = new RecyclerAdapterGroupList(this, Group.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
