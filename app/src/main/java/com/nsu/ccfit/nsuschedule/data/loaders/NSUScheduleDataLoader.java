package com.nsu.ccfit.nsuschedule.data.loaders;

import android.os.AsyncTask;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class NSUScheduleDataLoader extends AsyncTask<String, Void, Void> { //доработать тут класс
    @Override
    protected Void doInBackground(String... strings) {
        String scheduleUrl = strings[0];
        URL url = null;
        try {
            url = new URL(scheduleUrl);
            ReadableByteChannel rbc = Channels.newChannel(url.openConnection().getInputStream());
            FileOutputStream fos = new FileOutputStream(scheduleFile);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
