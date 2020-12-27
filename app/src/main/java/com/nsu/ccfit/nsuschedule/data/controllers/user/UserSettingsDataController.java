package com.nsu.ccfit.nsuschedule.data.controllers.user;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.github.cliftonlabs.json_simple.Jsoner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nsu.ccfit.nsuschedule.data.parser.json.IntervalJson;
import com.nsu.ccfit.nsuschedule.data.parser.json.UserSettingsJson;
import com.nsu.ccfit.nsuschedule.data.wrappers.user.UserSettingsData;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserSettingsDataController {
    private final static String USER_SETTINGS_FILE = "user_settings.json";
    private File userSettingsFile;

    public UserSettingsDataController(File filesDir) {
        this.userSettingsFile = new File(filesDir, USER_SETTINGS_FILE);
    }

    public File getUserSettingsFile() {
        return userSettingsFile;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setScheduleUrl(String scheduleUrl) throws IOException {
        if (!userSettingsFile.exists()) {
            userSettingsFile.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(userSettingsFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(userSettingsFile));

        Gson gson = new Gson();
        UserSettingsJson userSettingsJson = gson.fromJson(reader, UserSettingsJson.class);
        if (userSettingsJson == null) {
            userSettingsJson = new UserSettingsJson();
        }
        userSettingsJson.setScheduleUrl(scheduleUrl);
        String string = gson.toJson(userSettingsJson);

        //Jsoner.serialize(gson, writer);
        writer.write(string);
        writer.close();
        reader.close();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public UserSettingsData addDefaultSettings(byte[] hash) throws IOException {
        UserSettingsData userSettingsData = new UserSettingsData(
                hash
                , true
                , false
                , true
        );
        BufferedReader reader = new BufferedReader(new FileReader(userSettingsFile));
        IntervalJson intervalJson = new IntervalJson();

        intervalJson.setHash(userSettingsData.getHash());
        intervalJson.setAlarm(userSettingsData.isAlarmAllowed());
        intervalJson.setNotifications(userSettingsData.isNotificationsAllowed());
        intervalJson.setIsVisible(userSettingsData.isVisible());

        Gson gson = new Gson();
        UserSettingsJson userSettingsJson = gson.fromJson(reader, UserSettingsJson.class);
        ArrayList<IntervalJson> intervalJsonArrayList = userSettingsJson.getIntervalJsons();
        if (intervalJsonArrayList == null) {
            intervalJsonArrayList = new ArrayList<>();
        }
        intervalJsonArrayList.add(intervalJson);
        userSettingsJson.setIntervalJsons(intervalJsonArrayList);

        String string = gson.toJson(userSettingsJson);

        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(userSettingsFile));
        writer.write(string);
        writer.close();
        return userSettingsData;
    }

    public void deleteSettingsFor(byte[] hash) {
        ///////////////////TO DO
    }
}