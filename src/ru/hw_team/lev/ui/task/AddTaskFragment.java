package ru.hw_team.lev.ui.task;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import com.danikula.aibolit.annotation.InjectView;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.model.database.factory.HelperFactory;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;
import ru.hw_team.lev.ui.main.MainActivity;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Oleg Illiashenko
 *         Email: ctanok@gmail.com
 *         Date: 20.08.13
 */
public class AddTaskFragment extends BaseFragment{

    private static final String TAG = MainActivity.class.getSimpleName();
    String[] status = {"Не выполнено", "Выполняется", "Выполнено"};
    String[] priority = {"Низкий", "Обычный", "Высокий", "Особенный"};

    static final int DIALOG_TIME = 1;
    static final int DIALOG_DATE = 0;
    int Year, Month, Day, Hour, Minute;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_add_fragment, null);
        Aibolit.doInjections(this, view);
        defaultDateTime();
        return view;
    }

    /**
     * Не пиши в методе
     * switch (v.getId()) {
     * case R.id.btnTaskCancel:
     *
     * Така конструкция используеться тех методах которые срабатывают при клике на один из нескольких элементов.
     * Тоесть есть ообработчик 10 кнопок и ты с помощью swich определяешь какя из 10 была нажата.
     */

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

    @InjectOnClickListener(R.id.taskTimeInfoTv)
    private void onTaskTimeInfoTvClick(View v) {
    //    showDialog(DIALOG_TIME);
        showToastMessage("showDialog(DIALOG_TIME)");
    }

    @InjectOnClickListener(R.id.taskDateInfoTv)
    private void onTaskDateInfoTv(View v) {
      //  showDialog(DIALOG_DATE);
        showToastMessage("showDialog(DIALOG_DATE)");
    }

    protected Dialog onCreateDialog(int id) {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date yearDate = new Date();
        Year = Integer.parseInt(yearFormat.format(yearDate));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        Date monthDate = new Date();
        Month = Integer.parseInt(monthFormat.format(monthDate));
        Month--;

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date dayDate = new Date();
        Day = Integer.parseInt(dayFormat.format(dayDate));

        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Date hourDate = new Date();
        Hour = Integer.parseInt(hourFormat.format(hourDate));

        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        Date minuteDate = new Date();
        Minute = Integer.parseInt(minuteFormat.format(minuteDate));
        switch(id){
            case DIALOG_DATE:
               //return new DatePickerDialog(this, CallBackDate, Year, Month, Day);
              showToastMessage("DatePickerDialog");
            case DIALOG_TIME:
         //       return new TimePickerDialog(this, CallBackTime, Hour, Minute, true);
                showToastMessage("TimePickerDialog");
        }
        return null;
    }

    OnDateSetListener CallBackDate = new OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Year = year;
            Month = monthOfYear +1;
            Day = dayOfMonth;
            tvDate.setText(Year  + "/" + Month + "/" + Day);
        }
    };

    OnTimeSetListener CallBackTime = new OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Hour = hourOfDay;
            Minute = minute;
            tvTime.setText(Hour + ":" + Minute);
        }
    };


    @InjectOnClickListener(R.id.taskStatusSpinner)
    private void onTaskStatusSpinnerClick(View v) {
        ArrayAdapter<String> adapterStatus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerStatus.setAdapter(adapterStatus);
        spinnerStatus.setPrompt("Статус");
        spinnerStatus.setSelection(0);
        spinnerStatus.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    private void prioritySpinner() {
        ArrayAdapter<String> adapterPriority = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, priority);
        adapterPriority.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPriority.setAdapter(adapterPriority);
        spinnerPriority.setPrompt("Приоритет");
        spinnerPriority.setSelection(1);
        spinnerPriority.setOnItemSelectedListener(new OnItemSelectedListener() {
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
        getActivity().onBackPressed();
    }


    @InjectOnClickListener(R.id.btnTaskAdd)
    private void onBtnTaskAddclick(View v) throws ParseException {
        String description = etDes.getText().toString();
        String title = etTitle.getText().toString();
        String dateStr = tvDate.getText().toString();
        String timeStr = tvTime.getText().toString();
        String dateTimeStr = dateStr + " " + timeStr;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = format.parse(dateTimeStr);
        int status = spinnerStatus.getSelectedItemPosition();
        int priority = spinnerPriority.getSelectedItemPosition();
        if (description.equals("") || title.equals("")) {
            showToastMessage("Не все поля заполнены!");
        }
        else {
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
            showToastMessage("New Task was add!");
        }
    }

    private void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


}
