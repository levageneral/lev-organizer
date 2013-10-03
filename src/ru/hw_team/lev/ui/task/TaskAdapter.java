package ru.hw_team.lev.ui.task;

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
 * Date: 16.09.13
 */
public class TaskAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private ArrayList<Task> taskList;
    private Context cont;

    public TaskAdapter(Context context, ArrayList<Task> arTaskList) {
        cont = context;
        taskList = arTaskList;
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
        Task task = ((Task) getItem(position));
        //((TextView) view.findViewById(R.id.tvTaskDesList)).setText(task.description);
        ((TextView) view.findViewById(R.id.tvTaskDesList)).setText(task.getDescription());
        String statusSrt = task.getStatus().toString();
        ((TextView) view.findViewById(R.id.tvStatusList)).setText(statusSrt);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String dateStr = dateFormat.format(task.getDate());
        ((TextView) view.findViewById(R.id.tvDateList)).setText(dateStr);
        return view;
    }
}
