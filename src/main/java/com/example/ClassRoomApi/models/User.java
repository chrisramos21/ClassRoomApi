package com.example.ClassRoomApi.models;

import com.example.ClassRoomApi.helpers.UserType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(unique = true, length = 150, nullable = false)
    private String email;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(unique = true, length = 254, nullable = false )
    private String password;
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;
    @Column(name = "user_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    //Estableciendo la relación uno a uno con la tabla docente

    @OneToOne(mappedBy = "user")
    @JsonBackReference(value = "teacher-user")
    private Teacher teacher;

    @OneToOne(mappedBy = "user")
    @JsonBackReference(value = "student-user")
    private Student student;

    public User() {
    }

    public User(Integer id, UserType userType, String phoneNumber, String password, String name, String email) {
        this.id = id;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}