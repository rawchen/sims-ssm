package com.yoyling.domain;

import java.io.Serializable;

public class College implements Serializable {
    private Integer collegeId;

    private String collegeName;

    private String collegeProperty;

    private String collegeTeacherNumber;

    private static final long serialVersionUID = 1L;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public String getCollegeProperty() {
        return collegeProperty;
    }

    public void setCollegeProperty(String collegeProperty) {
        this.collegeProperty = collegeProperty == null ? null : collegeProperty.trim();
    }

    public String getCollegeTeacherNumber() {
        return collegeTeacherNumber;
    }

    public void setCollegeTeacherNumber(String collegeTeacherNumber) {
        this.collegeTeacherNumber = collegeTeacherNumber == null ? null : collegeTeacherNumber.trim();
    }
}