package com.ercan.model;

public class UserDTO {
    private String username;
    private int userAge;

    public UserDTO(String username, int userAge) {
        this.username = username;
        this.userAge = userAge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
