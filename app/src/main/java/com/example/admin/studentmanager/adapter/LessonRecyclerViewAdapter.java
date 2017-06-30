package com.example.admin.studentmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.studentmanager.OnListItemCallback;
import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.model.Lesson;

import java.util.List;

/**
 * Created by admin on 24.06.2017.
 */

public class LessonRecyclerViewAdapter extends Adapter<LessonViewHolder> {

    private static final String TAG = LessonRecyclerViewAdapter.class.getSimpleName();
    private List<Lesson> mData;
    private LayoutInflater mInflater;
    private OnListItemCallback callback;

    public LessonRecyclerViewAdapter(Context context, List<Lesson> data, OnListItemCallback callback) {
        mData = data;
        this.mInflater = LayoutInflater.from(context);
        this.callback = callback;
    }

    @Override
    public LessonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, " onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_lesson_item, parent, false);
        LessonViewHolder holder= new LessonViewHolder(view, callback);
        return holder;
    }

    @Override
    public void onBindViewHolder(LessonViewHolder holder, int position) {
        Log.d(TAG, " onBindViewHolder " + position);
        Lesson lesson = mData.get(position);
        holder.setData(lesson, position);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

}
