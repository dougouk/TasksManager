package com.dan190.manager.activity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.dan190.manager.R;
import com.dan190.manager.activity.TaskEditActivity;
import com.dan190.manager.activity.Tasks.TaskListAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by T2 on 1/7/2016.
 */
public class TaskEditFragment extends Fragment {
    public static final String DEFAULT_FRAGMENT_TAG = "taskEditFragment";

    //Views
    View rootView;
    EditText titleText;
    EditText notesText;
    ImageView imageView;

    long taskId;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        Bundle arguments = getArguments();

        if (arguments != null){
            taskId = arguments.getLong(TaskEditActivity.EXTRA_TASKID, 0L);
        }

        if (savedInstance != null)
        {
            taskId = savedInstance.getLong("TASK_ID");
        }
    }

    @Override
    public void  onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putLong(TASK_ID, taskId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle SavedInstance){
        View v = inflater.inflate(R.layout.fragment_task_edit, container, false);

        rootView = v.getRootView();
        titleText = (EditText) v.findViewById(R.id.title);
        notesText = (EditText) v.findViewById(R.id.notes);
        imageView = (ImageView) v.findViewById(R.id.image);

        Picasso.with(getActivity())
                .load(TaskListAdapter.getImageUrlForTask(taskId))
                .into(imageView);
        return v;
    }

    public static TaskEditFragment newInstance(long id){
        TaskEditFragment fragment = new TaskEditFragment();
        Bundle args = new Bundle();
        args.putLong(TaskEditActivity.EXTRA_TASKID, id);
        fragment.setArguments(args);
        return fragment;
    }
}
