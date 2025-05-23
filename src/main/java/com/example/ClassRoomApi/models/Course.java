package com.example.ClassRoomApi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer id;
    @Column(length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_teacher", referencedColumnName = "id_teacher")
    @JsonBackReference(value = "teacher-course")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference(value = "course-subject")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference(value = "course-assistance")
    private List<Assistance> assistances;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference(value = "course-inscription")
    private List<Inscription> inscriptions;


    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}