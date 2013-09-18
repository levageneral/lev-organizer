package ru.hw_team.lev.ui;

import android.*;
import android.R.layout.*;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import ru.hw_team.lev.model.database.dao.TaskDAO;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.model.database.factory.HelperFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 05.09.13
 */
public class TaskShowListActivity extends ListActivity {

   private ArrayList<Task> taskArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.task_show_list_activity);

        ListView listView  = (ListView) findViewById(R.id.lvTask);

        taskArrayList = new ArrayList<Task>();
        try {
            taskArrayList = (ArrayList<Task>) HelperFactory.getHelper().getTaskDAO().getAllTask();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TaskAdapter taskAdapter;
        taskAdapter = new TaskAdapter(this, taskArrayList);
        setListAdapter(taskAdapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //String item = (String) getListAdapter().getItem((int) id);
        // Toast.makeText(this, item + " выбран", Toast.LENGTH_LONG).show();
        Toast.makeText(this, " выбран", Toast.LENGTH_LONG).show();
    }

}
