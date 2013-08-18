package ru.hw_team.lev.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 18.08.13
 */
public class ScheduleAddActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_add_activity);
        Aibolit.doInjections(this);
    }

    @InjectOnClickListener(R.id.btnScheduleCancel)
    private void onBtnScheduleCancelClick(View v) {

        switch (v.getId()) {
            case R.id.btnScheduleCancel:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
