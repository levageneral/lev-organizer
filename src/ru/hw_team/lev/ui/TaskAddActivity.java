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
import java.text.SimpleDateFormat;
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

    static final int DIALOG_TIME = 1;

    static final int DIALOG_DATE = 0;



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
        defaultDateTime();

    }

    private void defaultDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        tvDate.setText(dateStr);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date time = new Date();
        String timeStr = timeFormat.format(time);
        tvTime.setText(timeStr);
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
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date yearDate = new Date();
        int Year = Integer.parseInt(yearFormat.format(yearDate));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        Date monthDate = new Date();
        int  Month = Integer.parseInt(monthFormat.format(monthDate));

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date dayDate = new Date();
        int Day = Integer.parseInt(dayFormat.format(dayDate));


        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Date hourDate = new Date();
        int Hour = Integer.parseInt(hourFormat.format(hourDate));

        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        Date minuteDate = new Date();
        int Minute = Integer.parseInt(minuteFormat.format(minuteDate));
         switch(id){
            case DIALOG_DATE:
                return new DatePickerDialog(this, CallBackDate, Year, Month, Day);
            case DIALOG_TIME:
                return new TimePickerDialog(this, CallBackTime, Hour, Minute, true);
        }
        return null;
    }

    OnDateSetListener CallBackDate = new OnDateSetListener() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date yearDate = new Date();
        int Year = Integer.parseInt(yearFormat.format(yearDate));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        Date monthDate = new Date();
        int  Month = Integer.parseInt(monthFormat.format(monthDate));

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date dayDate = new Date();
        int Day = Integer.parseInt(dayFormat.format(dayDate));

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Year = year;
            Month = monthOfYear + 1;
            Day = dayOfMonth;
            tvDate.setText(Year  + "/" + Month + "/" + Day);
        }
    };

    OnTimeSetListener CallBackTime = new OnTimeSetListener() {
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Date hourDate = new Date();
        int Hour = Integer.parseInt(hourFormat.format(hourDate));

        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        Date minuteDate = new Date();
        int Minute = Integer.parseInt(minuteFormat.format(minuteDate));

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

        if (description.equals("") || title.equals(""))
        {
            Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show();
        }
         else
        {
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



}