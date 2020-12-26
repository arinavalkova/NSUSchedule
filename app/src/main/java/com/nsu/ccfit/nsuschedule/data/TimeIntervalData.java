package com.nsu.ccfit.nsuschedule.data;

public class TimeIntervalData {
    private final NSUServerData nsuServerData;
    private final UserSettingsData userSettingsData;

    public TimeIntervalData(NSUServerData nsuServerData, UserSettingsData userSettingsData) {
        this.nsuServerData = nsuServerData;
        this.userSettingsData = userSettingsData;
    }

    public NSUServerData getNsuServerData() {
        return nsuServerData;
    }

    public UserSettingsData getUserSettingsData() {
        return userSettingsData;
    }
}
