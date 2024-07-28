package com.ercan.model;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + '}';
    }

    public class UserMapper {

        public static UserDTO toDto(User user) {
            return new UserDTO(user.getName(), user.getAge());
        }

        public static User toEntity(UserDTO userDTO) {
            return new User(userDTO.getUsername(), userDTO.getUserAge());
        }
    }
}
