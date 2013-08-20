package ru.hw_team.lev.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import com.danikula.aibolit.annotation.InjectView;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 18.08.13
 */
public class TaskAddActivity extends Activity {

    int DIALOG_TIME = 1;
    int Hour = 14;
    int Minute = 35;

    int DIALOG_DATE = 1;
    int Year = 2013;
    int Month = 07;
    int Day = 20;


    @InjectView(R.id.taskDescriptionEt)
    private EditText etDes;

    @InjectView(R.id.taskTitleEt)
    private EditText etTitle;

    @InjectView(R.id.taskTimeInfoTv)
    private TextView tvTime;

    @InjectView(R.id.taskDateInfoTv)
    private TextView tvDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_add_activity);
        Aibolit.doInjections(this);
    }

    @InjectOnClickListener(R.id.btnTaskCancel)
    private void onBtnTaskCancelClick(View v) {
        switch (v.getId()) {
            case R.id.btnTaskCancel:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @InjectOnClickListener(R.id.taskTimeInfoTv)
    private void onTaskTimeInfoTvClick(View v) {
        showDialog(DIALOG_TIME);
    }

    @InjectOnClickListener(R.id.taskDateInfoTv)
    private void onTaskDateInfoTv(View v) {
        showDialog(DIALOG_DATE);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, CallBackDate, Year, Month, Day);
            return tpd;
        }
        else if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, CallBackTime, Hour, Minute, true);
            return tpd;
        }

        return super.onCreateDialog(id);
    }

    OnDateSetListener CallBackDate = new OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            Year = year;
            Month = monthOfYear;
            Day = dayOfMonth;
            tvDate.setText(Day + "/" + Month + "/" + Year);
        }
    };

    OnTimeSetListener CallBackTime = new OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Hour = hourOfDay;
            Minute = minute;
            tvTime.setText(Hour + ":" + Minute);
        }
    };





    @InjectOnClickListener(R.id.btnTaskAdd)
    private void onBtnTaskAddclick(View v){
        String description = etDes.getText().toString();
    }

}