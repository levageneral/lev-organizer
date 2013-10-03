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

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static MainActivity instance;
    private SlidingMenu slidingMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        setContentView(R.layout.main_activity);
        Aibolit.doInjections(this);
        LauncherFragment.INSTANCE.setFragmentManager(getSupportFragmentManager());
        LauncherFragment.INSTANCE.setHomeFragment();

        initSlidingMenu();
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public SlidingMenu getSlidingMenu() {
        return slidingMenu;
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
        int displayWidth = DisplayHelper.getDisplaySize(this)[DisplayHelper.WIDTH_CELL];
        slidingMenu.setBehindOffset(displayWidth - DisplayHelper.dpToPx(175));
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
}
