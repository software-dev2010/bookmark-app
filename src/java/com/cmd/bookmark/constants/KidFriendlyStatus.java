package com.cmd.bookmark.constants;

public enum KidFriendlyStatus {

    APPROVED("Approved"),
    REJECTED("Rejected"),
    UNKNOWN("Unknown");

    private KidFriendlyStatus(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
