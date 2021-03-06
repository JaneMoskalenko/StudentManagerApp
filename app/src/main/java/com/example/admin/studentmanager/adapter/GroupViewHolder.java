package com.example.admin.studentmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.studentmanager.OnListItemCallback;
import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.model.Group;

/**
 * Created by admin on 24.06.2017.
 */

class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView title;
    ImageView imgThumb;
    int position;
    Group mGroup;
    private OnListItemCallback callback;

    public GroupViewHolder(View itemView, OnListItemCallback callback) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tvTitle);
        imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
        this.callback= callback;
        itemView.setOnClickListener(this);
    }

    public void setData(Group group, int position) {
        this.title.setText(group.getGroupName());
        this.imgThumb.setImageResource(group.getImageID());
        this.position=position;
        this.mGroup =group;
    }

    @Override
    public void onClick(View v) {
        callback.onClick(mGroup);
    }
}
