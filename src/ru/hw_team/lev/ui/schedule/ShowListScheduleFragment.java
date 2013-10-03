package ru.hw_team.lev.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.danikula.aibolit.Aibolit;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 26.09.13
 */
public class ShowListScheduleFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_list_schedule_fragment, null);
        Aibolit.doInjections(this, view);
        showToastMessage("BtnShowListSchedule was Click!");
        return view;
    }

    private void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
