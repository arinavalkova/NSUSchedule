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
        DataController dataController = new DataController();
        dataController.loadNSUServerData();
        dataController.printData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}