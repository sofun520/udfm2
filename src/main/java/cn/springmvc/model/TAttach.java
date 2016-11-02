package cn.springmvc.model;

import java.util.Date;

public class TAttach {
    private Integer tId;

    private String tName;

    private String tPath;

    private Date tDate;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettPath() {
        return tPath;
    }

    public void settPath(String tPath) {
        this.tPath = tPath == null ? null : tPath.trim();
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }
}