package com.nsu.ccfit.nsuschedule.data;

import com.nsu.ccfit.nsuschedule.data.server.NSUServerDataController;
import com.nsu.ccfit.nsuschedule.data.user.UserSettingsDataController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataController {
    private final NSUServerDataController nsuServerDataController;
    private final UserSettingsDataController userSettingsDataController;

    public DataController(File filesDir) {
        this.nsuServerDataController = new NSUServerDataController(filesDir);
        this.userSettingsDataController = new UserSettingsDataController(filesDir);
    }

    public Boolean loadNSUServerData() throws IOException {
        return nsuServerDataController.loadData(userSettingsDataController.getScheduleUrl());
        //return result string to show user difference in schedule
    }

    public Data getData() {
        return createData();
    }

    //---TEST
    public void printData() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader(nsuServerDataController.getNSUScheduleFile()));
            String line;
            while ((line = fin.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Data createData() {
        return null;
    }

    public UserSettingsDataController getUserSettingsDataController() {
        return userSettingsDataController;
    }
}
