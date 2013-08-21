package ru.hw_team.lev.ui.activities;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;
import ru.hw_team.lev.ui.basefragment.LauncherFragment;

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private SlidingMenu menu;
//    @InjectView(R.id.sliding_menu)
//    private SlidingMenu slidingMenu;
/*
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

//        SlidingMenu menu = new SlidingMenu(this);
//        menu.setMode(SlidingMenu.LEFT);
//        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        menu.setFadeDegree(0.35f);
//        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//        menu.setMenu(R.layout.menu);
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        menu.setShadowWidthRes(R.dimen.shadow_width);
//        menu.setShadowDrawable(R.drawable.shadow);
//        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu);
        menu.setBehindScrollScale(0.0f);
        menu.setBehindCanvasTransformer(getCanvasTransformer());
    }

    private SlidingMenu.CanvasTransformer getCanvasTransformer(){
        return new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                float scale = (float) (percentOpen*0.25 + 0.75);
                canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);
            }
        };
    }

    @Override
    public void onBackPressed() {
        if (menu.isMenuShowing()) {
            menu.showContent();
            return;
        }

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
