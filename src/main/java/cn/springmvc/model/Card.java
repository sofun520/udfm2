package cn.springmvc.model;

import java.util.Date;

public class Card {
    private Integer cId;

    private String cType;

    private String cNo;

    private Integer cBankId;

    private Date cDate;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public String getcNo() {
        return cNo;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo == null ? null : cNo.trim();
    }

    public Integer getcBankId() {
        return cBankId;
    }

    public void setcBankId(Integer cBankId) {
        this.cBankId = cBankId;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }
}