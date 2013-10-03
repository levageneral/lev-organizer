package ru.hw_team.lev.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;
import ru.hw_team.lev.ui.basefragment.LauncherFragment;

/**
 * Это наше боковое меню. Оно сделано фрагментом.
 */
public class SlideMenuFragment extends BaseFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.side_menu_fragment, null);
        Aibolit.doInjections(this, view);

        return view;
    }

    @InjectOnClickListener(R.id.add_task_btn)
    private void onBtnAddTaskClick(View v) {
        LauncherFragment.INSTANCE.setAddTaskFragment();
        getSlidingMenu().toggle();
    }

    @InjectOnClickListener(R.id.add_schedule_btn)
    private void onBtnAddScheduleClick(View v) {
        LauncherFragment.INSTANCE.setAddScheduleFragment();
        getSlidingMenu().toggle();
    }

    @InjectOnClickListener(R.id.show_list_task_btn)
    private void onBtnShowListTaskClick(View v) {
        LauncherFragment.INSTANCE.setShowListTaskFragment();
    }

    @InjectOnClickListener(R.id.show_list_schedule_btn)
    private void onBtnShowListScheduleClick(View v) {
        LauncherFragment.INSTANCE.setShowListScheduleFragment();
    }

    /**
     * Метод который получает объект меню из MainActivity
     * @return SlidingMenu
     */
    private SlidingMenu getSlidingMenu(){
         return MainActivity.getInstance().getSlidingMenu();
    }
}
