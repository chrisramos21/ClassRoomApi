package com.example.ClassRoomApi.helpers;

public enum ApiMessage {

    TEACHER_NOT_FOUND("El docente que buscas no se encuentra en BD"),

    STUDENT_NOT_FOUND("El estudiante que buscas no se encuentra en BD"),

    COURSE_NOT_FOUND("El curso que buscas no se encuentra en BD"),

    USER_NOT_FOUND("El usuario que buscas no se encuentra en BD"),

    ASSISTANCE_NOT_FOUND("La asistencia que buscas no se encuentra en BD"),

    GRADE_NOT_FOUND("La calificación que buscas no se encuentra en la BD"),

    INSCRIPTION_NOT_FOUND("La inscripción que buscas no se encuentra en la BD"),

    SUBJECT_NOT_FOUND("La materia que buscas no se encuentra en la BD");

    private String text;

    ApiMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
