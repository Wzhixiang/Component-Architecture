package com.wzx.issue.task;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wzx.data.entity.InnerTaskExecutor;
import com.wzx.issue.R;

import java.util.List;

/**
 * Description：
 * FileName：TaskAdapter
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<InnerTaskExecutor> mData;

    public TaskAdapter(List<InnerTaskExecutor> list) {
        this.mData = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        InnerTaskExecutor item = mData.get(position);
        holder.titleView.setText(item.getTitle());

        if (!TextUtils.isEmpty(item.getName())) {
            holder.executorView.setText(item.getName());
            holder.executorView.setVisibility(View.VISIBLE);
        } else {
            holder.executorView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView titleView, executorView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            titleView = itemView.findViewById(R.id.tv_title);
            executorView = itemView.findViewById(R.id.tv_executor);
        }
    }
}
