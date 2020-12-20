package com.nsu.ccfit.nsuschedule.data;

import java.io.File;

public class DataController {
    private final NSUServerDataController nsuServerDataController;
    private final UserSettingsController userSettingsController;
    private final File dir;

    public DataController(File filesDir) {
        this.dir = filesDir;
        this.nsuServerDataController = new NSUServerDataController();
        this.userSettingsController = new UserSettingsController();
    }

    public boolean loadNSUServerData() {
        return nsuServerDataController.loadData(dir);
    }

    public Data getData() {
        return createData();
    }

    //---TEST
    public void printData() {
        nsuServerDataController.printData();
    }

    private Data createData() {
        return null;
    }

    public boolean updateUserSettingsData(int id, TimeIntervalData timeIntervalData) {
        return false;
    }
}
