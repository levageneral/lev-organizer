package ru.hw_team.lev.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.danikula.aibolit.Aibolit;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;
import ru.hw_team.lev.ui.basefragment.LauncherFragment;

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
   /*
    @InjectView(R.id.description_tv)
    private TextView tvDes;

    @InjectView(R.id.description_et)
    private EditText etDes;

    @InjectView(R.id.tvStatus)
    private TextView tvStatus;

    @InjectView(R.id.etStatus)
    private EditText etStatus;

    @InjectView(R.id.tvDate)
    private TextView tvDate;

    @InjectView(R.id.etDate)
    private EditText etDate;
    */
    //Button btnGoTask;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Aibolit.doInjections(this);
        LauncherFragment.INSTANCE.setFragmentManager(getSupportFragmentManager());
        LauncherFragment.INSTANCE.setHomeFragment();
    }


    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = LauncherFragment.INSTANCE.getFragmentManager();
        BaseFragment baseFragment = (BaseFragment) fragmentManager.findFragmentById(R.id.fragment);

        if (fragmentManager.getBackStackEntryCount() <= 1) {
            finish();
        } else {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.remove(baseFragment);
            try {
                ft.commit();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            fragmentManager.popBackStackImmediate();
        }
    }
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
//}
