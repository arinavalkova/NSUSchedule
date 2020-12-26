package com.nsu.ccfit.nsuschedule.data.user;

import java.io.File;

public class UserSettingsDataController {
    private String scheduleUrl;
    private File fileDir;

    public UserSettingsDataController(File filesDir) {
        this.fileDir = filesDir;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }

    public File getUserSettingsFile() {
        return null;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }
}
