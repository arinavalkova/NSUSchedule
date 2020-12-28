package com.nsu.ccfit.nsuschedule;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.nsu.ccfit.nsuschedule.data.DataController;

import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataController dataController = new DataController(getFilesDir());
        try {
            if (!dataController.loadNSUServerData()) {
                loadChooseGroupActivity();
            }
            System.out.println(dataController.getData());
        } catch (IOException | ParserException e) {
            e.printStackTrace();
        }

        setContentView(R.layout.activity_main);
    }

    private void loadChooseGroupActivity() {
        Intent intent = new Intent(this, ChooseGroupActivity.class);
        startActivity(intent);
    }
}