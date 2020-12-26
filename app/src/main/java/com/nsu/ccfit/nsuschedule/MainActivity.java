package com.nsu.ccfit.nsuschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nsu.ccfit.nsuschedule.data.DataController;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataController dataController = new DataController(getFilesDir());
        dataController.setScheduleUrl("https://table.nsu.ru/ics/group/20206");
        try {
            System.out.println(dataController.loadNSUServerData()); //--> would return String to show user diff
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataController.printData();
    }
}