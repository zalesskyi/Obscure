package com.zalesskyi.android.obscure.view.main_operation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Event;
import com.zalesskyi.android.obscure.model.Place;
import com.zalesskyi.android.obscure.model.User;
import com.zalesskyi.android.obscure.view.main_operation.adapters.MainListAdapter;
import com.zalesskyi.android.obscure.view.main_operation.listeners.ItemListener;

import java.util.Date;

/**
 * Created by Алексей on 26.04.2018.
 */

public class MainFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MainListAdapter mAdapter;

    private ItemListener<Event> mEventItemListener = new ItemListener<Event>() {
        @Override
        public void open(Event item) {
            Toast.makeText(getContext(), "Open", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void remove(Event item) {
            Toast.makeText(getContext(), "Remove", Toast.LENGTH_SHORT).show();
        }
    };

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, parent, false);

        mRecyclerView = v.findViewById(R.id.main_recycler_view);

        mAdapter = new MainListAdapter(getActivity(), mEventItemListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fillList();
        return v;
    }

    private void fillList() {

        Event event = new Event(1, "Poltava Battle", new User("Petr", "http://www.grandars.ru/images/1/review/pr/28/d3fe70d58c.jpg"),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Marten%27s_Poltava.jpg/1200px-Marten%27s_Poltava.jpg"
                , new Date().getTime(), new Place(getContext(), 50.0, 50.0));

        mAdapter.addItem(event);

        Event event1 = new Event(2, "Borodino Battle", new User("Napoleon", "https://yt3.ggpht.com/-SJEf3I5HVSI/AAAAAAAAAAI/AAAAAAAAAAA/_sC4z8-IPs8/s48-c-k-no-mo-rj-c0xffffff/photo.jpg"),
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Battle_of_Borodino_1812.png/1200px-Battle_of_Borodino_1812.png"
                , new Date().getTime(), new Place(getContext(), 34.623376, 49.575849));

        mAdapter.addItem(event1);
    }
}
