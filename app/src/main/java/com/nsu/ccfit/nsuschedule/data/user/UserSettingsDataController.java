package com.nsu.ccfit.nsuschedule.data.user;

import java.io.File;

public class UserSettingsDataController {
    private String scheduleUrl = "https://table.nsu.ru/ics/group/20206";
    private File fileDir;

    public UserSettingsDataController(File filesDir) {
        this.fileDir = filesDir;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }
}
