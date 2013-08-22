package ru.hw_team.lev.ui.task;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import com.danikula.aibolit.annotation.InjectView;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;

/**
 * @author Oleg Illiashenko
 *         Email: ctanok@gmail.com
 *         Date: 20.08.13
 */
public class AddTaskFragment extends BaseFragment{

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
    protected int getLayoutResource() {
        return R.layout.task_add_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        Aibolit.doInjections(this, view);

        return view;
    }

    /**
     * Не пиши в методе
     * switch (v.getId()) {
     * case R.id.btnTaskCancel:
     *
     * Така конструкция используеться тех методах которые срабатывают при клике на один из нескольких элементов.
     * Тоесть есть ообработчик 10 кнопок и ты с помощью swich определяешь какя из 10 была нажата.
     * @param v
     */
    @InjectOnClickListener(R.id.btnTaskCancel)
    private void onBtnTaskCancelClick(View v) {
        getActivity().onBackPressed();
    }

    @InjectOnClickListener(R.id.taskTimeInfoTv)
    private void onTaskTimeInfoTvClick(View v) {
        getActivity().showDialog(DIALOG_TIME);
    }

    @InjectOnClickListener(R.id.taskDateInfoTv)
    private void onTaskDateInfoTv(View v) {
        getActivity().showDialog(DIALOG_DATE);
    }

//    protected Dialog onCreateDialog(int id) {
//        if (id == DIALOG_DATE) {
//            DatePickerDialog tpd = new DatePickerDialog(getActivity(), CallBackDate, Year, Month, Day);
//            return tpd;
//        }
//        else if (id == DIALOG_TIME) {
//            TimePickerDialog tpd = new TimePickerDialog(getActivity(), CallBackTime, Hour, Minute, true);
//            return tpd;
//        }
//
//        return super.onCreateDialog(id);
//    }

    DatePickerDialog.OnDateSetListener CallBackDate = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            Year = year;
            Month = monthOfYear;
            Day = dayOfMonth;
            tvDate.setText(Day + "/" + Month + "/" + Year);
        }
    };

    TimePickerDialog.OnTimeSetListener CallBackTime = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Hour = hourOfDay;
            Minute = minute;
            tvTime.setText(Hour + ":" + Minute);
        }
    };





    @InjectOnClickListener(R.id.btnTaskAdd)
    private void onBtnTaskAddclick(View v){
        showToastMessage("On Add button click!");
//        String description = etDes.getText().toString();
    }

    private void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
