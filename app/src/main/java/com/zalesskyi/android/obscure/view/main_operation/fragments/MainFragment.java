package com.zalesskyi.android.obscure.view.main_operation.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Event;
import com.zalesskyi.android.obscure.view.main_operation.adapters.MainListAdapter;
import com.zalesskyi.android.obscure.view.main_operation.listeners.IMainListener;
import com.zalesskyi.android.obscure.view.main_operation.listeners.ItemListener;

import java.util.List;


public class MainFragment extends Fragment implements IMainListener.IDashboardCallback {

    private RecyclerView mRecyclerView;
    private TextView mEmptyListTextView;

    private MainListAdapter mAdapter;
    private IMainListener mMainListener;

    private ItemListener<Event> mEventItemListener = new ItemListener<Event>() {
        @Override
        public void open(Event item) {
            Toast.makeText(getContext(), "Open", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void remove(Event item) {
            Toast.makeText(getContext(), "Remove", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void apply(Event item) {

        }
    };

    public static MainFragment newInstance(IMainListener mainListener) {
        return new MainFragment(mainListener);
    }

    public MainFragment() {

    }

    @SuppressLint("ValidFragment")
    public MainFragment(IMainListener mainListener) {
        mMainListener = mainListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, parent, false);

        mRecyclerView = v.findViewById(R.id.main_recycler_view);
        mEmptyListTextView = v.findViewById(R.id.empty_list_text);

        mAdapter = new MainListAdapter(getActivity(), mEventItemListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mMainListener.getFeed(this);
        return v;
    }

    @Override
    public void showFeed(List<Event> events) {
        mAdapter.addItems(events.toArray(new Event[events.size()]));
    }

    @Override
    public void showEmptyList() {
        mRecyclerView.setVisibility(View.INVISIBLE);
        mEmptyListTextView.setVisibility(View.VISIBLE);
    }
}
