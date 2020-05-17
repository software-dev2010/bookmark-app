package com.cmd.bookmark.constants;

public enum UserType {

    USER("User"),
    EDITOR("Editor"),
    CHIEF_EDITOR("Chiefeditor");

    private UserType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
