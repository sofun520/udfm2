package cn.springmvc.model;

import java.util.Date;

public class TEnum {
    private Integer eId;

    private String eCode;

    private String eKey;

    private String eValue;

    private Date eDate;

    private String eDescription;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode == null ? null : eCode.trim();
    }

    public String geteKey() {
        return eKey;
    }

    public void seteKey(String eKey) {
        this.eKey = eKey == null ? null : eKey.trim();
    }

    public String geteValue() {
        return eValue;
    }

    public void seteValue(String eValue) {
        this.eValue = eValue == null ? null : eValue.trim();
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public String geteDescription() {
        return eDescription;
    }

    public void seteDescription(String eDescription) {
        this.eDescription = eDescription == null ? null : eDescription.trim();
    }
}