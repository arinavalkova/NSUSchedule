package com.nsu.ccfit.nsuschedule.data.loaders;

import android.os.AsyncTask;
import android.os.Build;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class NSUScheduleDataLoader extends AsyncTask<File, Void, Void> { //доработать тут класс

    @Override
    protected Void doInBackground(File... files) {
        try {
            if (files[0].createNewFile()){
                System.out.println("File is created!");
            }
            else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String scheduleUrl = "https://table.nsu.ru/ics/group/20201";
        URL url = null;
        try {
            url = new URL(scheduleUrl);
            ReadableByteChannel rbc = Channels.newChannel(url.openConnection().getInputStream());
            FileOutputStream fos = new FileOutputStream(files[0]);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
            BufferedReader fin = new BufferedReader(new FileReader(files[0]));
            String line;
            while ((line = fin.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
