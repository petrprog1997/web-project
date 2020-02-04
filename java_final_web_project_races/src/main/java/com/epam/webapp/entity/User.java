package com.epam.webapp.entity;

public class User implements Identifiable {

    public static final String TABLE = "users";
    public static final String ID = "user_id";
    public static final String LOGIN = "user_login";
    public static final String PASSWORD = "user_password";
    public static final String STATUS = "user_status";
    public static final String TYPE = "user_type";
    public static final String MONEY_BALANCE = "user_money_balance";

    private Long userId;
    private String userLogin;
    private String userPassword;
    private UserStatus userStatus;
    private UserType userType;
    private double moneyBalance;

    public User(String userLogin, String userPassword, UserStatus userStatus, UserType userType, double moneyBalance) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
        this.userType = userType;
        this.moneyBalance = moneyBalance;
    }

    public User(Long userId, String userLogin, String userPassword, UserStatus userStatus, UserType userType, double moneyBalance) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
        this.userType = userType;
        this.moneyBalance = moneyBalance;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(double moneyBalance) {
        this.moneyBalance = moneyBalance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (Double.compare(user.moneyBalance, moneyBalance) != 0) return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userLogin != null ? !userLogin.equals(user.userLogin) : user.userLogin != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;
        if (userStatus != user.userStatus) return false;
        return userType == user.userType;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        temp = Double.doubleToLongBits(moneyBalance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userStatus=" + userStatus +
                ", userType=" + userType +
                ", moneyBalance=" + moneyBalance +
                '}';
    }

}
