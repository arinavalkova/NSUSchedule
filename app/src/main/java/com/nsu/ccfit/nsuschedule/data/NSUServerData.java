package com.nsu.ccfit.nsuschedule.data;

public class NSUServerData {
    private final byte[] hash;
    private final String location;
    private final String description;
    private final String summary;
    private final WeekDay weekDay;
    private final int interval;
    private boolean isRecentlyUpdated;

    public NSUServerData(String location, String description, String summary, WeekDay weekDay, int interval) {
        this.location = location;
        this.description = description;
        this.summary = summary;
        this.weekDay = weekDay;
        this.interval = interval;
        this.isRecentlyUpdated = true;
        this.hash = new Hasher().getStringHash(location + description + summary + weekDay + interval);
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public int getInterval() {
        return interval;
    }

    public byte[] getHash() {
        return hash;
    }

    public boolean isRecentlyUpdated() {
        return isRecentlyUpdated;
    }

    public void setRecentlyUpdated(boolean isRecentlyUpdated) {
        this.isRecentlyUpdated = isRecentlyUpdated;
    }
}
