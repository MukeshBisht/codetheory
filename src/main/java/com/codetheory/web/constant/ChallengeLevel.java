package com.codetheory.web.constant;

public enum ChallengeLevel {

    Easy(1, "Easy"), Medium(2, "Medium"), Hard(3, "Hard");

    private int value;
    private String name;

    private ChallengeLevel(int val, String name) {
        this.value = val;
        this.name = name;
    }

    private ChallengeLevel(int val) {
        this.value = val;
        switch (val) {
        case 1:
            this.name = "Easy";
            break;
        case 2:
            this.name = "Medium";
            break;
        case 3:
            this.name = "Hard";
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