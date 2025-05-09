package com.example.ClassRoomApi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    private Integer id;
    @Column(length = 100, nullable = false)
    private String expertise;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference(value = "teacher-course")
    private List<Course> courses;

    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    @JsonManagedReference(value = "teacher-user")
    private User user;

    public Teacher() {
    }

    public Teacher(Integer id, String expertise) {
        this.id = id;
        this.expertise = expertise;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}
