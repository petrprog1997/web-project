package com.epam.webapp.entity;

import java.sql.Date;
import java.util.List;

public class Run implements Identifiable {

    public static final String TABLE = "runs";
    public static final String ID = "run_id";
    public static final String RUN_DATE = "run_date";
    public static final String RUN_STATUS = "run_status";
    public static final String RUN_WINNER  = "run_winner";

    private int runId;
    private String runDate;
    private RunStatus runStatus;
    private int runWinner;
    private List<RunParticipant> runParticipants;

    public Run(String runDate, RunStatus runStatus, int runWinner) {
        this.runDate = runDate;
        this.runStatus = runStatus;
        this.runWinner = runWinner;
    }

    public Run(int runId, String runDate, RunStatus runStatus, int runWinner) {
        this.runId = runId;
        this.runDate = runDate;
        this.runStatus = runStatus;
        this.runWinner = runWinner;
    }

    public Run(String runDate, RunStatus runStatus, int runWinner, List<RunParticipant> runParticipants) {
        this.runDate = runDate;
        this.runStatus = runStatus;
        this.runWinner = runWinner;
        this.runParticipants = runParticipants;
    }

    public Run(int runId, String runDate, RunStatus runStatus, int runWinner, List<RunParticipant> runParticipants) {
        this.runId = runId;
        this.runDate = runDate;
        this.runStatus = runStatus;
        this.runWinner = runWinner;
        this.runParticipants = runParticipants;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    public void setRunWinner(int runWinner) {
        this.runWinner = runWinner;
    }

    public int getRunWinner() {
        return runWinner;
    }

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }

    public RunStatus getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(RunStatus runStatus) {
        this.runStatus = runStatus;
    }

    public List<RunParticipant> getRunParticipants() {
        return runParticipants;
    }

    public void setRunParticipants(List<RunParticipant> runParticipants) {
        this.runParticipants = runParticipants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Run run = (Run) o;

        if (runId != run.runId) return false;
        if (runWinner != run.runWinner) return false;
        if (runDate != null ? !runDate.equals(run.runDate) : run.runDate != null) return false;
        if (runStatus != run.runStatus) return false;
        return runParticipants != null ? runParticipants.equals(run.runParticipants) : run.runParticipants == null;
    }

    @Override
    public int hashCode() {
        int result = runDate != null ? runDate.hashCode() : 0;
        result = 31 * result + (runStatus != null ? runStatus.hashCode() : 0);
        result = 31 * result + runWinner;
        result = 31 * result + runId;
        result = 31 * result + (runParticipants != null ? runParticipants.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Run{" +
                "runId = " + runId +
                "runDate =" + runDate +
                ", runStatus =" + runStatus +
                ", runParticipants = " + runParticipants +
                '}';
    }
}
