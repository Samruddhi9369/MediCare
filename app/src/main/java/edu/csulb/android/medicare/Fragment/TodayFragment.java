package edu.csulb.android.medicare.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import edu.csulb.android.medicare.Adapter.RecyclerAdapter;
import edu.csulb.android.medicare.Adapter.RecyclerAlarmAdapter;
import edu.csulb.android.medicare.Database.MedicationDatabaseHelper;
import edu.csulb.android.medicare.Database.PillBox;
import edu.csulb.android.medicare.Model.MedicationInformation;
import edu.csulb.android.medicare.Model.Reminder;
import edu.csulb.android.medicare.R;
/*
* Description: Fragment to update Today's reminders
* */
public class TodayFragment extends Fragment {
    List<Reminder> reminders;
    PillBox pillBox =  new PillBox();
    List<MedicationInformation> medicationInformations = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    //private RecyclerView.Adapter adapter;
    private RecyclerAlarmAdapter recyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        //TableLayout stk = (TableLayout) view.findViewById(R.id.table_today);
        
        MedicationDatabaseHelper db = new MedicationDatabaseHelper(getActivity());
        //User user = new User("sam","kal","email","8978675645","pwd","cpwd");
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        try {
            reminders = pillBox.getAlarms(getContext(),day);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        recyclerView =
                (RecyclerView) view.findViewById(R.id.recycler_alarm_view);

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAlarmAdapter(reminders,getActivity());
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

}
