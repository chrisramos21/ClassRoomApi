package com.example.ClassRoomApi.helpers;

public enum ApiMessage {

    TEACHER_NOT_FOUND("El docente que buscas no se encuentra en BD"),
    STUDENT_NOT_FOUND("El estudiante que buscas no se encuentra en BD"),
    USER_NOT_FOUND("El usuario que buscas no se encuentra en BD");

    private final String text;

    ApiMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

