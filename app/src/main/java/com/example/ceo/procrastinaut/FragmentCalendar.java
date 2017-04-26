/*package com.example.ceo.procrastinaut;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public class FragmentCalendar extends Fragment {
    public ArrayList<Event> eventList = new ArrayList<Event>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd",Locale.US);
    GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("EST"));

    public static Fragment newInstance(Context context) {
        FragmentCalendar f = new FragmentCalendar();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        //Create a separate calendar to edit
        //Need Listeners for event
        ListAdapter adapter = new EventListAdapter(getActivity(), R.layout.notification_list_item, eventList);
        ListView listview = (ListView)root.findViewById(R.id.eventList);
        listview.setAdapter(adapter);

        c.setOnDateChangeListener(new OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,int dayOfMonth) {
                //ADD EVENT CODE FOR WHAT TO DO ON SELECTED DAY
            }
        });


        return root;
    }

}*/