package com.example.admin.studentmanager.app.Lesson;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.app.GettingStartedActivity;
import com.example.admin.studentmanager.manager.LessonManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 30.06.2017.
 */

public class AddLessonActivity extends Activity {
    EditText edt_setLessonTitle, edt_setLessonDescription;
    EditText edt_setTime, edt_setDate;
    Button btn_submit_add_lesson, btn_setTime, btn_setDate;
    String mTime, mDate;
    Date dateLesson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lesson);

        edt_setLessonTitle = (EditText) findViewById(R.id.edt_setLessonTitle);
        edt_setLessonDescription = (EditText) findViewById(R.id.edt_setLessonDescription);

        edt_setTime = (EditText) findViewById(R.id.edt_setTime);
        edt_setDate = (EditText) findViewById(R.id.edt_setDate);

        btn_submit_add_lesson = (Button) findViewById(R.id.btn_submit_add_lesson);
        btn_setTime = (Button) findViewById(R.id.btn_setTime);
        btn_setDate= (Button) findViewById(R.id.btn_setDate);

        btn_setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                      //  Toast.makeText(AddLessonActivity.this, hourOfDay + " " + minute, Toast.LENGTH_LONG).show();
                        mTime = hourOfDay + ":" + minute;
                        edt_setTime.setText(mTime);
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddLessonActivity.this, timeSetListener, 9, 0, true);
                timePickerDialog.show();
            }
        });

        btn_setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener mylistener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mDate = year + "." + month + "." + dayOfMonth;
                        edt_setDate.setText(mDate);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddLessonActivity.this, mylistener, 2017, 06, 07);
                datePickerDialog.show();
            }
        });

        btn_submit_add_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertbuilder = new AlertDialog.Builder(AddLessonActivity.this);
                alertbuilder.setTitle("Сохранить урок?");
                alertbuilder.setMessage("Пожалуйста, подтвердите подтверждение урока");
                alertbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        SimpleDateFormat format_Date = new SimpleDateFormat("yyyy.MM.dd hh:mm");
                        try {
                            dateLesson = format_Date.parse(mDate +" "+ mTime);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (LessonManager.addNewLesson(edt_setLessonTitle.getText().toString(),
                                dateLesson, dateLesson, "",
                                edt_setLessonDescription.getText().toString())) {
                            Toast.makeText(AddLessonActivity.this, "Урок добавлен", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(AddLessonActivity.this, LessonListActivity.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(AddLessonActivity.this, "Произошла ошибка. Урок не добавлен", Toast.LENGTH_LONG).show();
                    }
                });
                alertbuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(AddLessonActivity.this, "Отмена", Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = alertbuilder.create();
                dialog.show();
            }
        });

    }
}
