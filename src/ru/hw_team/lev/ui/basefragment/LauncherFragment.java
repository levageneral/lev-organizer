package ru.hw_team.lev.ui.basefragment;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.home.HomeFragment;
import ru.hw_team.lev.ui.schedule.AddScheduleFragment;
import ru.hw_team.lev.ui.schedule.ShowListScheduleFragment;
import ru.hw_team.lev.ui.task.AddTaskFragment;
import ru.hw_team.lev.ui.task.ShowListTaskFragment;

/**
 * @author Oleg Illiashenko
 *         Email: ctanok@gmail.com
 *         Date: 20.08.13
 *
 *         Это сингелтон (патерн проектирования) почитай на хабре статью как постоить сингелтон через enum
 *         Этот класс используеться для вызова фрагментов.
 */
public enum LauncherFragment {
    INSTANCE;

    private FragmentManager fragmentManager;

    public void setHomeFragment() {
        startFragment(new HomeFragment());
    }

    public void setAddTaskFragment() {
        startFragment(new AddTaskFragment());
    }

    public void setAddScheduleFragment() {
        startFragment(new AddScheduleFragment());
    }

    public void setShowListTaskFragment() {
        startFragment(new ShowListTaskFragment());
    }

    public void setShowListScheduleFragment() {
        startFragment(new ShowListScheduleFragment());
    }

    private void startFragment(BaseFragment baseFragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, baseFragment);
        fragmentTransaction.addToBackStack(baseFragment.getClass().getName());
        fragmentTransaction.commit();
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }


}
