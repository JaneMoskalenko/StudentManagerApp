package com.example.admin.studentmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.studentmanager.OnListItemCallback;
import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.model.Group;

import java.util.List;

/**
 * Created by admin on 24.06.2017.
 */

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupViewHolder> {

    private static final String TAG = GroupRecyclerViewAdapter.class.getSimpleName();
    private List<Group> mData;
    private LayoutInflater mInflater;
    private OnListItemCallback callback;

    public GroupRecyclerViewAdapter(Context context, List<Group> data, OnListItemCallback callback) {
        mData = data;
        this.mInflater = LayoutInflater.from(context);
        this.callback = callback;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, " onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_group_item, parent, false);
        GroupViewHolder holder= new GroupViewHolder(view, callback);
        return holder;
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        Log.d(TAG, " onBindViewHolder " + position);
        Group group = mData.get(position);
        holder.setData(group, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
