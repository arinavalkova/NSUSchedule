package com.nsu.ccfit.nsuschedule.data;

import java.util.ArrayList;

public class Data {
    private ArrayList<TimeIntervalData> dataList;

    public Data() {
        this.dataList = new ArrayList<>();
    }

    public ArrayList<TimeIntervalData> getWeekDayTimeIntervalDataList(WeekDay weekDay) {
        ArrayList<TimeIntervalData> weekDayTimeIntervalDataList = new ArrayList<>();
        for (TimeIntervalData currentTimeIntervalData : dataList) {
            if (currentTimeIntervalData.getNsuServerData().getWeekDay().equals(weekDay))
                weekDayTimeIntervalDataList.add(currentTimeIntervalData);
        }
        return weekDayTimeIntervalDataList;
    }

    private void addTimeIntervalData(TimeIntervalData timeIntervalData) {
        this.dataList.add(timeIntervalData);
    }
}
