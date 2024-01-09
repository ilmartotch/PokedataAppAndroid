package com.example.progettobackground;

public class States {
    private Boolean started = false;

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public Boolean getStarted() {
        return started;
    }


    private boolean startedForeground = false;

    public void setStartedForeground(boolean startedForeground) {
        this.startedForeground = startedForeground;
    }

    public Boolean getStartedForeground(){return startedForeground;}
    public boolean isStartedForeground() {
        return startedForeground;
    }

}
