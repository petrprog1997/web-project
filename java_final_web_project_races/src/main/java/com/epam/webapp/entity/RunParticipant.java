package com.epam.webapp.entity;

public class RunParticipant implements Identifiable {

    public static final String TABLE = "run_participants";
    public static final String ID = "run_participant_id";
    public static final String RUN_ID = "run_id";
    public static final String HORSE_NAME = "run_participant_horse_name";
    public static final String RACE_NUMBER = "race_participant_number";
    public static final String RUN_PLACE = "run_participant_place";

    private String horseName;
    private int runNumber;
    private int runPlace;
    private int runId;

    public RunParticipant(String horseName, int runNumber, int runPlace) {
        this.horseName = horseName;
        this.runNumber = runNumber;
        this.runPlace = runPlace;
    }

    public RunParticipant(int runId, String horseName, int runNumber, int runPlace) {
        this.runId = runId;
        this.horseName = horseName;
        this.runNumber = runNumber;
        this.runPlace = runPlace;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public int getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(int runNumber) {
        this.runNumber = runNumber;
    }

    public int getRunPlace() {
        return runPlace;
    }

    public void setRunPlace(int runPlace) {
        this.runPlace = runPlace;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RunParticipant that = (RunParticipant) o;

        if (runNumber != that.runNumber) return false;
        if (runPlace != that.runPlace) return false;
        return horseName != null ? horseName.equals(that.horseName) : that.horseName == null;
    }

    @Override
    public int hashCode() {
        int result = horseName != null ? horseName.hashCode() : 0;
        result = 31 * result + runNumber;
        result = 31 * result + runPlace;
        return result;
    }

    @Override
    public String toString() {
        return "RunParticipant{" +
                "horseName='" + horseName + '\'' +
                ", runNumber=" + runNumber +
                ", runPlace=" + runPlace +
                "runId" + runId +
                '}';
    }
}
