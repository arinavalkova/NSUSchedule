package com.nsu.ccfit.nsuschedule.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nsu.ccfit.nsuschedule.data.parser.DataParser;
import com.nsu.ccfit.nsuschedule.data.controllers.server.NSUServerDataController;
import com.nsu.ccfit.nsuschedule.data.controllers.user.UserSettingsDataController;
import com.nsu.ccfit.nsuschedule.data.wrappers.Data;

import net.fortuna.ical4j.data.ParserException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataController {
    private final NSUServerDataController nsuServerDataController;         //может их убрать, они есть в парсере
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
        return nsuServerDataController.loadData(dataParser.parseScheduleUrl());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Data getData() throws IOException, ParserException {
        return dataParser.getParsedData();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setScheduleUrl(String scheduleUrl) throws IOException {
        userSettingsDataController.setScheduleUrl(scheduleUrl);
    }
}
