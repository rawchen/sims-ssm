package com.yoyling.domain;

import java.io.Serializable;

public class Score implements Serializable {
    private Integer scoreId;

    private String xh;

    private String kch;

    private String cj;

    private Float jd;

    private Float xf;

    private static final long serialVersionUID = 1L;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch == null ? null : kch.trim();
    }

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj == null ? null : cj.trim();
    }

    public Float getJd() {
        return jd;
    }

    public void setJd(Float jd) {
        this.jd = jd;
    }

    public Float getXf() {
        return xf;
    }

    public void setXf(Float xf) {
        this.xf = xf;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", xh='" + xh + '\'' +
                ", kch='" + kch + '\'' +
                ", cj='" + cj + '\'' +
                ", jd=" + jd +
                ", xf=" + xf +
                '}';
    }
}