package com.nsu.ccfit.nsuschedule.data;

public class DataController {
    private final NSUServerDataController nsuServerDataController;
    private final UserSettingsController userSettingsController;

    public DataController() {
        this.nsuServerDataController = new NSUServerDataController();
        this.userSettingsController = new UserSettingsController();
    }

    public boolean loadNSUServerData() {
        return nsuServerDataController.loadData(userSettingsController.getScheduleUrl());
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
