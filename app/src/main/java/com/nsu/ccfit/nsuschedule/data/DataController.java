package com.nsu.ccfit.nsuschedule.data;

import com.nsu.ccfit.nsuschedule.data.parser.DataParser;
import com.nsu.ccfit.nsuschedule.data.server.NSUServerDataController;
import com.nsu.ccfit.nsuschedule.data.user.UserSettingsDataController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataController {
    private final NSUServerDataController nsuServerDataController;
    private final UserSettingsDataController userSettingsDataController;
    private final DataParser dataParser;

    public DataController(File filesDir) {
        this.nsuServerDataController = new NSUServerDataController(filesDir);
        this.userSettingsDataController = new UserSettingsDataController(filesDir);
        this.dataParser = new DataParser(
                this.nsuServerDataController
                , this.userSettingsDataController
        );
    }

    public Boolean loadNSUServerData() throws IOException {
        return nsuServerDataController.loadData(userSettingsDataController.getScheduleUrl());
    }

    public Data getData() {
        return dataParser.parsedData();
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

    public UserSettingsDataController getUserSettingsDataController() {
        return userSettingsDataController;
    }
}
