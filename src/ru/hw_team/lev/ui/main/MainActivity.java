package ru.hw_team.lev.ui.main;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.danikula.aibolit.Aibolit;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;
import ru.hw_team.lev.ui.basefragment.LauncherFragment;
import ru.hw_team.lev.util.DisplayHelper;

public class MainActivity extends FragmentActivity implements OnLoadFragmentListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private SlidingMenu slidingMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Aibolit.doInjections(this);
        LauncherFragment.INSTANCE.setFragmentManager(getSupportFragmentManager());
        LauncherFragment.INSTANCE.setHomeFragment();

        initSlidingMenu();
    }

    private void initSlidingMenu(){
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        menu.setShadowWidthRes(R.dimen.shadow_width);
//        menu.setShadowDrawable(R.drawable.shadow);
//        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.menu);
        slidingMenu.setBehindScrollScale(0.0f);
        slidingMenu.setBehindCanvasTransformer(getCanvasTransformer());
        slidingMenu.setBehindOffset(DisplayHelper.dpToPx(50));
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
        if (slidingMenu.isMenuShowing()) {
            slidingMenu.showContent();
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

    @Override
    public void onHomeLoad() {
    }

    @Override
    public void onTasksLoad() {
    }

    @Override
    public void onAddTaskLoad() {
    }

    @Override
    public void onSchedulesLoad() {
    }

    @Override
    public void onAddScheduleLoad() {
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
