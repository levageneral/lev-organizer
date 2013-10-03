package ru.hw_team.lev.ui.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ru.hw_team.lev.model.database.entity.Schedule;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.ui.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.model.database.factory.HelperFactory;
import ru.hw_team.lev.ui.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 19.09.13
 */
public class ScheduleAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private ArrayList<Schedule> scheduleList;
    private Context cont;

    public ScheduleAdapter(Context context, ArrayList<Schedule> arScheduleList) {
        cont = context;
        scheduleList = arScheduleList;
        lInflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return scheduleList.size();
    }

    @Override
    public Object getItem(int position) {
        return scheduleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = lInflater.inflate(R.layout.schedule_list_item, parent, false);
        }
        Schedule schedule = ((Schedule) getItem(position));
        ((TextView) view.findViewById(R.id.tvScheduleDesList)).setText(schedule.getDescription());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String dateStartStr = dateFormat.format(schedule.getDateStart());
        ((TextView) view.findViewById(R.id.tvDateStartList)).setText(dateStartStr);
        String dateEndStr = dateFormat.format(schedule.getDateEnd());
        ((TextView) view.findViewById(R.id.tvDateEndList)).setText(dateEndStr);
        return view;
    }
}