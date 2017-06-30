package com.example.admin.studentmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.studentmanager.OnListItemCallback;
import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.model.Student;

/**
 * Created by admin on 24.06.2017.
 */

class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView title;
    ImageView imgThumb;
    int position;
    Student mStudent;
    private OnListItemCallback callback;

    public StudentViewHolder(View itemView, OnListItemCallback callback) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tv_row);
        imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
        this.callback= callback;
        itemView.setOnClickListener(this);
    }

    public void setData(Student student, int position) {
        this.title.setText((position+1) + ". " + student.getName() + " " + student.getFirstName() + " " + student.getSurname());
        this.imgThumb.setImageResource(student.getImageID());
        this.position=position;
        this.mStudent =student;
    }

    @Override
    public void onClick(View v) {
        callback.onClick(mStudent);
    }

}
