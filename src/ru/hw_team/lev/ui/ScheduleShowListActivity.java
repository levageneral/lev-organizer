package ru.hw_team.lev.ui;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.danikula.aibolit.Aibolit;
import ru.hw_team.lev.model.database.entity.Schedule;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.model.database.factory.HelperFactory;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 05.09.13
 */
public class ScheduleShowListActivity extends ListActivity {

    private ArrayList<Schedule> scheduleArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.task_add_activity);
        //Aibolit.doInjections(this);
        ListView listView  = (ListView) findViewById(R.id.lvSchedule);

        scheduleArrayList = new ArrayList<Schedule>();
        try {
            scheduleArrayList = (ArrayList<Schedule>) HelperFactory.getHelper().getScheduleDAO().getAllSchedule();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ScheduleAdapter scheduleAdapter;
        scheduleAdapter = new ScheduleAdapter(this, scheduleArrayList);
        setListAdapter(scheduleAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Schedule schedule = (Schedule) getListAdapter().getItem(position);
        String scheduleDescription = schedule.getDescription();
        //String Status = task1.getStatus().toString();
        if (!TextUtils.isEmpty(scheduleDescription)) {
            Toast.makeText(this, "выбран" + ": " + scheduleDescription, Toast.LENGTH_LONG).show();
        }
    }
}
