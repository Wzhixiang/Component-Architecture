package com.wzx.issue.selectExecutor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wzx.data.entity.Executor;
import com.wzx.issue.R;

import java.util.List;

/**
 * Description：
 * FileName：SelectExecutorAdapter
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
public class SelectExecutorAdapter extends RecyclerView.Adapter<SelectExecutorAdapter.ExecutorViewHolder> {

    private List<Executor> mData;

    public SelectExecutorAdapter(List<Executor> list) {
        this.mData = list;
    }

    @NonNull
    @Override
    public ExecutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExecutorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_executor, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExecutorViewHolder holder, int position) {
        final Executor item = mData.get(position);
        holder.nameView.setText(item.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ExecutorViewHolder extends RecyclerView.ViewHolder {

        private TextView nameView;

        public ExecutorViewHolder(@NonNull View itemView) {
            super(itemView);

            nameView = itemView.findViewById(R.id.tv_executor);
        }
    }

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(Executor executor);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
