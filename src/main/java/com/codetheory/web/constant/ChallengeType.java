package com.codetheory.web.constant;

public enum ChallengeType {

    MCQ(1, "MCQ"), Code(2, "Code");

    private int value;
    private String name;

    private ChallengeType(int val, String name) {
        this.value = val;
        this.name = name;
    }

    private ChallengeType(int val) {
        this.value = val;
        switch (val) {
        case 1:
            this.name = "MCQ";
            break;
        case 2:
            this.name = "Code";
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