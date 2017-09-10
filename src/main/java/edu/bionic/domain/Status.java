package edu.bionic.domain;

/**
 * Created by denis on 29.08.17.
 */
public enum Status {
    OPEN("open"),
    INPROGRESS("inprogress"),
    QA("qa"),
    REOPENED("reopened"),
    CLOSED("closed");

    private final String val;

    Status(String val) {
        this.val = val;
    }

    public String getStatus() {
        return val;
    }
}
