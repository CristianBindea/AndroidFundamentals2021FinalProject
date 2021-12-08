package com.cristianbindea.androidfundamentals2021finalproject.ui.alltasksdone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cristianbindea.androidfundamentals2021finalproject.R;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;

import java.util.List;


public class TaskDoneListAdapter extends RecyclerView.Adapter<TaskDoneListAdapter.TaskDoneViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<TaskDone> tasksDone; // Cached copy of tasks
    TaskDoneListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TaskDoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.recyclerview_row_task_done, parent, false);
        return new TaskDoneViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskDoneViewHolder holder, int position) {
        if (tasksDone != null) {
            TaskDone current = tasksDone.get(position);

            holder.task_name.setText(current.getNameTaskDone());
            holder.task_start.setText(Integer.toString(current.getTimeStart()));
            holder.task_end.setText(Integer.toString(current.getTimeEnd()));
            holder.task_length.setText(Integer.toString(current.getTimeLength()));
        } else {
            // Covers the case of data not being ready yet.
            holder.task_name.setText("No Task Done");
            holder.task_start.setText("");
            holder.task_end.setText("");
            holder.task_length.setText("");
        }
    }

    void setTasksDone(List<TaskDone> tasks) {
        tasksDone = tasks;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (tasksDone != null)
            return tasksDone.size();
        else return 0;
    }

    class TaskDoneViewHolder extends RecyclerView.ViewHolder {
        private final TextView task_name, task_start, task_end, task_length;

        private TaskDoneViewHolder(View itemView) {
            super(itemView);
            task_name = itemView.findViewById(R.id.text_name_rv);
            task_start = itemView.findViewById(R.id.text_start_rv);
            task_end = itemView.findViewById(R.id.text_end_rv);
            task_length = itemView.findViewById(R.id.text_lenght_rv);
        }
    }
}