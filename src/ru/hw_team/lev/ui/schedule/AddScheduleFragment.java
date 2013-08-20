package ru.hw_team.lev.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;

/**
 * @author Oleg Illiashenko
 *         Email: ctanok@gmail.com
 *         Date: 20.08.13
 */
public class AddScheduleFragment extends BaseFragment {

    @Override
    protected int getLayoutResource() {
        return R.layout.add_schedule_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        Aibolit.doInjections(this, view);

        return view;
    }

    @InjectOnClickListener(R.id.btnScheduleCancel)
    private void onBtnScheduleCancelClick(View v) {
        getActivity().onBackPressed();
    }
}
