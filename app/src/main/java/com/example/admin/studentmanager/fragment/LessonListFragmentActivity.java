package com.example.admin.studentmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.studentmanager.R;

/**
 * Created by admin on 30.06.2017.
 */

public class LessonListFragmentActivity extends Fragment {
    private static final String TAG = LessonListFragmentActivity.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_lesson_list, container,false);
        Log.d(TAG, "onCreate View Fragment");
        return v;
    }

}
