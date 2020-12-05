package com.yoyling.domain;

import java.io.Serializable;

public class Classes implements Serializable {
    private Integer classesId;

    private Integer majorId;

    private String classesName;

    private Integer classesTaecherNumber;

    private static final long serialVersionUID = 1L;

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName == null ? null : classesName.trim();
    }

    public Integer getClassesTaecherNumber() {
        return classesTaecherNumber;
    }

    public void setClassesTaecherNumber(Integer classesTaecherNumber) {
        this.classesTaecherNumber = classesTaecherNumber;
    }
}