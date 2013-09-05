package ru.hw_team.lev.ui;

import android.app.Activity;
import android.os.Bundle;
import com.danikula.aibolit.Aibolit;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 05.09.13
 */
public class ScheduleShowListActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_add_activity);
        Aibolit.doInjections(this);
    }

}
