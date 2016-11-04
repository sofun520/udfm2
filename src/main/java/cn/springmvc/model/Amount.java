package cn.springmvc.model;

import java.math.BigDecimal;
import java.util.Date;

public class Amount
{
    private Integer aId;

    private String aType;

    private BigDecimal aSum;

    private String aWays;

    private Integer aCardId;

    private Integer aImg;

    private Date aDate;

    private String cNo;

    public String getcNo()
    {
        return cNo;
    }

    public void setcNo(String cNo)
    {
        this.cNo = cNo;
    }

    public Integer getaId()
    {
        return aId;
    }

    public void setaId(Integer aId)
    {
        this.aId = aId;
    }

    public String getaType()
    {
        return aType;
    }

    public void setaType(String aType)
    {
        this.aType = aType == null ? null : aType.trim();
    }

    public BigDecimal getaSum()
    {
        return aSum;
    }

    public void setaSum(BigDecimal aSum)
    {
        this.aSum = aSum;
    }

    public String getaWays()
    {
        return aWays;
    }

    public void setaWays(String aWays)
    {
        this.aWays = aWays == null ? null : aWays.trim();
    }

    public Integer getaCardId()
    {
        return aCardId;
    }

    public void setaCardId(Integer aCardId)
    {
        this.aCardId = aCardId;
    }

    public Integer getaImg()
    {
        return aImg;
    }

    public void setaImg(Integer aImg)
    {
        this.aImg = aImg;
    }

    public Date getaDate()
    {
        return aDate;
    }

    public void setaDate(Date aDate)
    {
        this.aDate = aDate;
    }
}