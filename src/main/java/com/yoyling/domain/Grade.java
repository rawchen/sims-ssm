package com.yoyling.domain;

import java.io.Serializable;

public class Grade implements Serializable {
    private Integer gradeId;

    private String gradeName;

    private String gradeTeacherNumber;

    private Integer collegeId;

    private static final long serialVersionUID = 1L;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public String getGradeTeacherNumber() {
        return gradeTeacherNumber;
    }

    public void setGradeTeacherNumber(String gradeTeacherNumber) {
        this.gradeTeacherNumber = gradeTeacherNumber == null ? null : gradeTeacherNumber.trim();
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
}