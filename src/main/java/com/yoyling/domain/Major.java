package com.yoyling.domain;

import java.io.Serializable;

public class Major implements Serializable {
    private Integer majorId;

    private Integer gradeId;

    private String majorName;

    private String majorTeacherNumber;

    private static final long serialVersionUID = 1L;

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getMajorTeacherNumber() {
        return majorTeacherNumber;
    }

    public void setMajorTeacherNumber(String majorTeacherNumber) {
        this.majorTeacherNumber = majorTeacherNumber == null ? null : majorTeacherNumber.trim();
    }
}