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
public class SideMenuFragment extends BaseFragment {

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

    @InjectOnClickListener(R.id.btnGoSchedule)
    private void onBtnAddScheduleClick(View v) {
        LauncherFragment.INSTANCE.setAddScheduleFragment();
        getSlidingMenu().toggle();
    }

    /**
     * Метод который получает объект меню из MainActivity
     * @return SlidingMenu
     */
    private SlidingMenu getSlidingMenu(){
         return MainActivity.getInstance().getSlidingMenu();
    }
}
