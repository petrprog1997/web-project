package com.epam.webapp.entity;

public class Bet implements Identifiable {

    public static final String TABLE = "bets";
    public static final String ID = "Bet_id";
    public static final String USER_LOGIN = "User_login";
    public static final String BET_TYPE = "Bet_type";
    public static final String BET_SIZE = "Bet_size";
    public static final String COEFFICIENT = "Coefficient";
    public static final String WINNING = "Winning";
    public static final String BET_STATUS = "Bet_status";

    private String userLogin;
    private BetType betType;
    private double betSize;
    private double coefficient;
    private double winning;
    private BetStatus betStatus;

    public Bet(String userLogin, BetType betType, double betSize, double coefficient, double winning, BetStatus betStatus) {
        this.userLogin = userLogin;
        this.betType = betType;
        this.betSize = betSize;
        this.coefficient = coefficient;
        this.winning = winning;
        this.betStatus = betStatus;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public double getBetSize() {
        return betSize;
    }

    public void setBetSize(double betSize) {
        this.betSize = betSize;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getWinning() {
        return winning;
    }

    public void setWinning(double winning) {
        this.winning = winning;
    }

    public BetStatus getBetStatus() {
        return betStatus;
    }

    public void setBetStatus(BetStatus betStatus) {
        this.betStatus = betStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (Double.compare(bet.betSize, betSize) != 0) return false;
        if (Double.compare(bet.coefficient, coefficient) != 0) return false;
        if (Double.compare(bet.winning, winning) != 0) return false;
        if (userLogin != null ? !userLogin.equals(bet.userLogin) : bet.userLogin != null) return false;
        if (betType != bet.betType) return false;
        return betStatus == bet.betStatus;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userLogin != null ? userLogin.hashCode() : 0;
        result = 31 * result + (betType != null ? betType.hashCode() : 0);
        temp = Double.doubleToLongBits(betSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coefficient);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(winning);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (betStatus != null ? betStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "userLogin='" + userLogin + '\'' +
                ", betType=" + betType +
                ", betSize=" + betSize +
                ", coefficient=" + coefficient +
                ", winning=" + winning +
                ", betStatus=" + betStatus +
                '}';
    }
}
