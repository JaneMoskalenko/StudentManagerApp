package com.example.admin.studentmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.model.Student;

/**
 * Created by admin on 24.06.2017.
 */

class StudentViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    ImageView imgThumb;
    int position;
    Student current;


    public StudentViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tv_row);
        imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
    }

    public void setData(Student current, int position) {
       // this.title.setText("Random text ");
        this.title.setText(current.getName() + " " + current.getFirstName() + " " + current.getSurname());
        this.imgThumb.setImageResource(current.getImageID());
        this.position=position;
        this.current=current;
    }
}
