package com.nsu.ccfit.nsuschedule;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.nsu.ccfit.nsuschedule.data.DataController;

import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DataController dataController = new DataController(getFilesDir());
        try {
            if (!dataController.loadNSUServerData()) {
                //go to choose group activity
                //dataController.setScheduleUrl("https://table.nsu.ru/ics/group/20206");
                //in chose group activity ->
                System.out.println(dataController.loadNSUServerData());
                //if this true getData method
            }
            System.out.println(dataController.getData());
        } catch (IOException | ParserException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}