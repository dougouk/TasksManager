package com.dan190.manager.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toolbar;

import com.dan190.manager.R;
import com.dan190.manager.activity.fragment.TaskEditFragment;

public class TaskEditActivity extends Activity {

    public static final String EXTRA_TASKID = "taskId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);
        //setActionBar((Toolbar)findViewById(R.id.Toolbar));

        long id = getIntent().getLongExtra(TaskEditActivity.EXTRA_TASKID, 0L);
        Fragment fragment = TaskEditFragment.newInstance(id);
        String fragmentTag = TaskEditFragment.DEFAULT_FRAGMENT_TAG;
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().add(
                    R.id.container,
                    fragment,
                    fragmentTag).commit();

        }
    }

}
