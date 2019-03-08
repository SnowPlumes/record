package me.lv.record.entity.dto;


import java.util.Date;

/**
 * @author lv
 */
public class InsertRecodeDTO extends BaseRecordDTO{
    private String areaCode;
    private Date effectiveTime;

    public InsertRecodeDTO() {
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    @Override
    public String toString() {
        return "InsertRecodeDTO{" +
                "areaCode='" + areaCode + '\'' +
                ", effectiveTime=" + effectiveTime +
                '}';
    }
}
