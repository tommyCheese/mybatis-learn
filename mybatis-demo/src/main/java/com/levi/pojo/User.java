package com.levi.pojo;

public class User {
    private Integer id;
    private String username;
    private String passwd;
    private  String gender;
    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return passwd;
    }

    public void setPassword(String password) {
        this.passwd = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return addr;
    }

    public void setAddress(String address) {
        this.addr = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + passwd + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + addr + '\'' +
                '}';
    }
}
