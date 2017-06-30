package com.example.admin.studentmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.studentmanager.OnListItemCallback;
import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.model.Lesson;

/**
 * Created by admin on 24.06.2017.
 */

class LessonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView title;
    int position;
    Lesson mLesson;
    private OnListItemCallback callback;

    public LessonViewHolder(View itemView, OnListItemCallback callback) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tvTitle);
        this.callback= callback;
        itemView.setOnClickListener(this);
    }

    public void setData(Lesson lesson, int position) {
        this.title.setText(lesson.getName());
        this.position=position;
        this.mLesson =lesson;
    }

    @Override
    public void onClick(View v) {
        callback.onClick(mLesson);
    }
}
