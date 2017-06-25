package com.example.admin.studentmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.model.Group;

/**
 * Created by admin on 24.06.2017.
 */

class GroupViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    ImageView imgThumb, imgDelete, imgAdd;
    int position;
    Group current;


    public GroupViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tvTitle);
        imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
        imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
        imgAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
    }

    public void setData(Group current, int position) {
        this.title.setText(current.getGroupName());
        this.imgThumb.setImageResource(current.getImageID());
        this.position=position;
        this.current=current;
    }
}
