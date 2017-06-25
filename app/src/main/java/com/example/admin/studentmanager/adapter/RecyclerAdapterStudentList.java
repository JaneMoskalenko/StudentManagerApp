package com.example.admin.studentmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.model.Student;

import java.util.List;

/**
 * Created by admin on 24.06.2017.
 */

public class RecyclerAdapterStudentList extends RecyclerView.Adapter<StudentViewHolder> {
    private static final String TAG = RecyclerAdapterStudentList.class.getSimpleName();
    private List<Student> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapterStudentList(Context context, List<Student> data) {
        mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, " onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_student_item, parent, false);
        StudentViewHolder holder= new StudentViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Log.d(TAG, " onCreateViewHolder " + position);
        Student currentobj = mData.get(position);
        holder.setData(currentobj, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
