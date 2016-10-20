package cn.springmvc.model;

import java.util.Date;

public class TMenu {
    private Integer mId;

    private String mName;

    private String mUrl;

    private Integer mParent;

    private String mType;

    private Date mDate;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl == null ? null : mUrl.trim();
    }

    public Integer getmParent() {
        return mParent;
    }

    public void setmParent(Integer mParent) {
        this.mParent = mParent;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType == null ? null : mType.trim();
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}