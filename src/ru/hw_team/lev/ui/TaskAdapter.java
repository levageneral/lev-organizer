package ru.hw_team.lev.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ru.hw_team.lev.model.database.dao.TaskDAO;
import ru.hw_team.lev.model.database.entity.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 16.09.13
 */
public class TaskAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private ArrayList<Task> taskList;
    private Context cont;

    public TaskAdapter(Context context, ArrayList<Task> myTaskList) {
        cont = context;
        taskList = myTaskList;
        lInflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = lInflater.inflate(R.layout.task_list_item, parent, false);
        }
        Task p = ((Task) getItem(position));
        ((TextView) view.findViewById(R.id.tvDesList)).setText(p.description);
        //((TextView) view.findViewById(R.id.tvDateList)).setText(p.date);
        //((TextView) view.findViewById(R.id.tvStatusList)).setText(p.status);
        return view;
    }
}
