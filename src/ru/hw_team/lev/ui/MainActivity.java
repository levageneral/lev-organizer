package ru.hw_team.lev.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import com.danikula.aibolit.annotation.InjectView;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.model.database.factory.HelperFactory;

import java.sql.SQLException;
import java.util.Date;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.description_tv)
    private TextView tvDes;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Aibolit.doInjections(this);
        Log.d(TAG, "LOG Message onCreate-1");
    }


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


}
