package com.nsu.ccfit.nsuschedule.data.server;

public class CallBack {
    private boolean result;
    public void callback(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }
}