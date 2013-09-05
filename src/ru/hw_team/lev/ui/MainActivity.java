package ru.hw_team.lev.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import com.danikula.aibolit.annotation.InjectView;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.model.database.factory.HelperFactory;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.content.Intent;

import static ru.hw_team.lev.ui.R.id.btnGoTask;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Aibolit.doInjections(this);
    }

    @InjectOnClickListener(R.id.btnGoTask)
    private void onBtnAddTaskClick(View v) {
        Intent intent = new Intent(this, TaskAddActivity.class);
        startActivity(intent);

        }


    @InjectOnClickListener(R.id.btnGoSchedule)
    private void onBtnAddScheduleClick(View v) {
         Intent intent = new Intent(this, ScheduleAddActivity.class);
         startActivity(intent);
    }

    @InjectOnClickListener(R.id.btnShowListTask)
    private void onBtnShowListTaskClick(View v) {

    }

    @InjectOnClickListener(R.id.btnShowListSchedule)
    private void onBtnShowListScheduleClick(View v) {

    }








  /*
    @InjectOnClickListener(R.id.btnAdd)
    private void onBtnAddClick(View v) {
        Log.d(TAG, "LOG Message onClick-1");
        String description = etDes.getText().toString();
        Date date = new Date();
        Log.d(TAG, "LOG Message onClick description: " + description);
        Task task = new Task(0, description, "Подпись", date, 1, 2);

        try {
            HelperFactory.getHelper().getTaskDAO().createTask(task);
            Log.d(TAG, "try HelperFactory.getHelper().getTaskDAO().createTask(task)");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(TAG, "catch SQLException");
        }

        Toast.makeText(this, "Text:" + description + "was add", Toast.LENGTH_LONG).show();

    }

    @InjectOnClickListener(R.id.get_all_btn)
    public void onButtonGetAllTaskClick(View view) {
        printAllTask();
    }

    private void printAllTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        List<Task> tasks = null;
        try {
            tasks = HelperFactory.getHelper().getTaskDAO().getAllTask();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task != null) {
                    Log.d(TAG, "===========START============");
                    Log.d(TAG, " Title = " + task.getTitle());
                    Log.d(TAG, " Description = " + task.getDescription());
                    Log.d(TAG, " Date = " + dateFormat.format(task.getDate()));
                    Log.d(TAG, "============END=============");
                }
            }
        }
    } */
}
