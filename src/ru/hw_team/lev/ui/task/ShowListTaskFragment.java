package ru.hw_team.lev.ui.task;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import ru.hw_team.lev.model.database.entity.Task;
import ru.hw_team.lev.model.database.factory.HelperFactory;
import ru.hw_team.lev.ui.R;
import ru.hw_team.lev.ui.basefragment.BaseFragment;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 26.09.13
 */
public class ShowListTaskFragment extends BaseFragment {

    private ArrayList<Task> taskArrayList;
    protected ListView listView;
    protected ListActivity listActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_list_task_fragment, null);
        Aibolit.doInjections(getActivity(), view);
        showToastMessage("BtnShowListTask was Click!");
       // showList();
        return view;
    }
   /*
    @ViewById(android.R.list)
    protected ListView listView;
    newsAdapter = new NewsAdapter(getActivity())
    listView.setAdapter(newsAdapter)

     */



    @InjectOnClickListener(R.id.lvTask)
    private void onLvTaskClick(View v) {


   }
    /*
    private void showList() {
        taskArrayList = new ArrayList<Task>();
        try {
            taskArrayList = (ArrayList<Task>)  HelperFactory.getHelper().getTaskDAO().getAllTask();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TaskAdapter taskAdapter;
        taskAdapter = new TaskAdapter(getActivity(), taskArrayList);
        listView.setAdapter(taskAdapter);
    }


    protected void onListItemClick(ListView l, View v, int position, long id) {

        Task task = (Task) listActivity.getListAdapter().getItem(position);
        String taskDescription = task.getDescription();
        String taskStatus = task.getStatus().toString();
        if (!TextUtils.isEmpty(taskDescription)) {
             showToastMessage("выбран" + ": " + taskDescription + " "  + "Status" + " " + taskStatus);
        }
    }

      */
    private void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }



}
