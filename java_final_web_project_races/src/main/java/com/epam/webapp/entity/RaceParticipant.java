package com.epam.webapp.entity;

public class RaceParticipant implements Identifiable {

    public static final String TABLE = "race_participants";
    public static final String ID = "race_participant_id";
    public static final String HORSE_NAME = "race_participant_horse_name";
    public static final String RACE_NUMBER = "race_participant_number";

    private String horseName;
    private int runNumber;

    public RaceParticipant(String horseName, int runNumber) {
        this.horseName = horseName;
        this.runNumber = runNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceParticipant that = (RaceParticipant) o;

        if (runNumber != that.runNumber) return false;
        return horseName != null ? horseName.equals(that.horseName) : that.horseName == null;
    }

    @Override
    public int hashCode() {
        int result = horseName != null ? horseName.hashCode() : 0;
        result = 31 * result + runNumber;
        return result;
    }

    @Override
    public String toString() {
        return "RaceParticipant{" +
                "horseName=" + horseName +
                ", runNumber=" + runNumber +
                '}';
    }
}
