package ru.hw_team.lev.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import com.danikula.aibolit.annotation.InjectView;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.model.database.factory.HelperFactory;

import java.sql.SQLException;
import java.util.Date;


/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 18.08.13
 */
public class TaskAddActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    String[] status = {"Не выполнено", "Выполняется", "Выполнено"};
    String[] priority = {"Низкий", "Обычный", "Высокий", "Особенный"};

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

    @InjectView(R.id.taskPrioritySpinner)
    private Spinner spinnerPriority;

    @InjectView(R.id.taskStatusSpinner)
    private Spinner spinnerStatus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_add_activity);
        Aibolit.doInjections(this);
        statusSpinner();
        priorotySpinner();

    }
    private void statusSpinner() {
        ArrayAdapter<String> adapterStatus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner taskStatusSpinner = (Spinner) findViewById(R.id.taskStatusSpinner);

        taskStatusSpinner.setAdapter(adapterStatus);
        taskStatusSpinner.setPrompt("Статус");
        taskStatusSpinner.setSelection(0);
        taskStatusSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        int pos = taskStatusSpinner.getSelectedItemPosition();
    }
       private void priorotySpinner() {
           ArrayAdapter<String> adapterPriority = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, priority);
           adapterPriority.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           Spinner taskPrioritySpinner = (Spinner) findViewById(R.id.taskPrioritySpinner);

           taskPrioritySpinner.setAdapter(adapterPriority);
           taskPrioritySpinner.setPrompt("Приоритет");
           taskPrioritySpinner.setSelection(1);
           taskPrioritySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
               @Override
               public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
               }
               @Override
               public void onNothingSelected(AdapterView<?> arg0) {
               }
           });
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
    private void onBtnTaskAddClick(View v){
        String description = etDes.getText().toString();
        String title = etTitle.getText().toString();
        Date date = new Date();
        int status = spinnerStatus.getSelectedItemPosition();
        int priority = spinnerPriority.getSelectedItemPosition();

        Log.d(TAG, "LOG Message onClick description: " + description);
        Log.d(TAG, "LOG Message onClick title: " + title);
        Log.d(TAG, "LOG Message onClick date: " + date);
        Log.d(TAG, "LOG Message onClick status: " +  status);
        Log.d(TAG, "LOG Message onClick priority: " + priority);
        Task task = new Task(0, description, title, date, status, priority);

        try {
            HelperFactory.getHelper().getTaskDAO().createTask(task);
            Log.d(TAG, "try HelperFactory.getHelper().getTaskDAO().createTask(task)");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(TAG, "catch SQLException");
        }

        Toast.makeText(this, "New Task was add", Toast.LENGTH_LONG).show();

    }

}