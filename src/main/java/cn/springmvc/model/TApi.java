package cn.springmvc.model;

import java.util.Date;

public class TApi {
    private Integer aId;

    private String aName;

    private String aUrl;

    private String aRequestType;

    private String aParam;

    private Integer aCount;

    private String aDescription;

    private Date aDate;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getaUrl() {
        return aUrl;
    }

    public void setaUrl(String aUrl) {
        this.aUrl = aUrl == null ? null : aUrl.trim();
    }

    public String getaRequestType() {
        return aRequestType;
    }

    public void setaRequestType(String aRequestType) {
        this.aRequestType = aRequestType == null ? null : aRequestType.trim();
    }

    public String getaParam() {
        return aParam;
    }

    public void setaParam(String aParam) {
        this.aParam = aParam == null ? null : aParam.trim();
    }

    public Integer getaCount() {
        return aCount;
    }

    public void setaCount(Integer aCount) {
        this.aCount = aCount;
    }

    public String getaDescription() {
        return aDescription;
    }

    public void setaDescription(String aDescription) {
        this.aDescription = aDescription == null ? null : aDescription.trim();
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }
}