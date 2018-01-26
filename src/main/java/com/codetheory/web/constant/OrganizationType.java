package com.codetheory.web.constant;

public enum OrganizationType {

    School(1, "School"), Collage(2, "Collage"), Individual(3, "Individual"), Other(4, "Other");

    private int value;
    private String name;

    private OrganizationType(int val, String name) {
        this.value = val;
        this.name = name;
    }

    private OrganizationType(int val) {
        this.value = val;
        switch (val) {
        case 1:
            this.name = "School";
            break;
        case 2:
            this.name = "Collage";
            break;
        case 3:
            this.name = "Individual";
            break;
        case 4:
            this.name = "Other";
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