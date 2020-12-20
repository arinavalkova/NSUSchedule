package com.nsu.ccfit.nsuschedule.data;

import com.nsu.ccfit.nsuschedule.data.loaders.NSUScheduleDataLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class NSUServerDataController {
    //---TEST
    private final static String NSU_SCHEDULE_FILE = "nsu_schedule_file.txt";
    private File scheduleFile = new File(NSU_SCHEDULE_FILE);

    public boolean loadData(File dir) {
        NSUScheduleDataLoader nsuScheduleDataLoader = new NSUScheduleDataLoader();
        nsuScheduleDataLoader.execute(new File(dir, "text.ics"));
        return true;
    }

    //---TEST
    public void printData() {
        System.out.println(scheduleFile.toString());
    }
}
