package com.codetheory.web.constant;

public enum ContestStatus {

    RUNNING(0, "RUNNING"), ENDED(1, "ENDED"), NOTSTARTED(2, "NOTSTARTED");

    private int value;
    private String name;

    private ContestStatus (int val, String name) {
        this.value = val;
        this.name = name;
    }

    private ContestStatus (int val) {
        this.value = val;
        switch (val) {
        case 0:
            this.name = "RUNNING";
            break;
        case 1:
            this.name = "ENDED";
            break;
        case 2:
            this.name = "NOTSTARTED";
            break;
        }
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}