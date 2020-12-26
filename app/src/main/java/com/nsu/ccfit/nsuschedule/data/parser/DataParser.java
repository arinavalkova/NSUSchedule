package com.nsu.ccfit.nsuschedule.data.parser;

import com.nsu.ccfit.nsuschedule.data.Data;
import com.nsu.ccfit.nsuschedule.data.NSUServerData;
import com.nsu.ccfit.nsuschedule.data.UserSettingsData;
import com.nsu.ccfit.nsuschedule.data.server.NSUServerDataController;
import com.nsu.ccfit.nsuschedule.data.user.UserSettingsDataController;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class DataParser {
    private final NSUServerDataController nsuServerDataController;
    private final UserSettingsDataController userSettingsDataController;

    public DataParser(NSUServerDataController nsuServerDataController
            , UserSettingsDataController userSettingsDataController) {
        this.nsuServerDataController = nsuServerDataController;
        this.userSettingsDataController = userSettingsDataController;
    }

    public Data parsedData() {
        ArrayList<NSUServerData> nsuServerDataArrayList = parseNSUServerData(
                nsuServerDataController.getNSUScheduleFile()
        );
        ArrayList<NSUServerData> backUpArrayList = parseNSUServerData(
                nsuServerDataController.getBackUpScheduleFile()
        );
        for (NSUServerData currentNSUServerData : nsuServerDataArrayList) {
            for (NSUServerData currentBackUpData : backUpArrayList) {
                if (Arrays.equals(currentBackUpData.getHash(), currentNSUServerData.getHash())) {
                    currentNSUServerData.setRecentlyUpdated(false);
                    break;
                }
            }
        }
        ArrayList<UserSettingsData> userSettingsDataArrayList = parseUserSettingsData(
                userSettingsDataController.getUserSettingsFile()
        );

        return null;
    }

    private ArrayList<NSUServerData> parseNSUServerData(File nsuScheduleFile) {
        return null;
    }

    private ArrayList<UserSettingsData> parseUserSettingsData(File userSettingsFile) {
        return null;
    }
}
