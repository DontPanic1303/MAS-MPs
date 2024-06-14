package edu.pjatk.mas.s25278.masmp5.DTO;

public class LessonDTO {

    private int startTime;

    private boolean isReserveable;

    public LessonDTO(int startTime, boolean isReserveable) {
        this.startTime = startTime;
        this.isReserveable = isReserveable;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public boolean isReserveable() {
        return isReserveable;
    }

    public void setReserveable(boolean reserveable) {
        isReserveable = reserveable;
    }
}
