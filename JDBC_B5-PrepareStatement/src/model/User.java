package model;

public class User {
    private String userName;
    private String password;
    private String fullName;

    public User() {
    }

    public User(String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
    @Override
    public String toString() {
        return String.format("UserName: %-12s || Password: %-20s || FullName: %-20s ", getUserName(), getPassword(), getFullName());
    }
}
