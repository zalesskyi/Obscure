package com.zalesskyi.android.obscure.view.main_operation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Topic;

/**
 * Created by Алексей on 20.04.2018.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainListElementHolder> {
    private Topic[] mTopics;

    public MainListAdapter(Topic[] topics) {
        mTopics = topics;
    }

    @Override
    public MainListElementHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_element_holder, parent, false);

        return new MainListElementHolder(v);
    }

    @Override
    public void onBindViewHolder(MainListElementHolder holder, int position) {
        holder.bindMainListElement(mTopics[position]);
    }

    @Override
    public int getItemCount() {
        return mTopics.length;
    }

    class MainListElementHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mText;

        MainListElementHolder(View v) {
            super(v);
            mTitle = v.findViewById(R.id.tvListTopic);
            mText = v.findViewById(R.id.tvListDesc);
        }

        public void bindMainListElement(Topic topic) {
            mTitle.setText(topic.getName());
            mText.setText(topic.getDescription());
        }
    }
}
