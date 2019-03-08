package me.lv.record.entity.dto;

import java.util.Date;

/**
 * @author lv
 */
public class UpdateRecordDTO extends BaseRecordDTO {
    private Integer id;
    private String areaCode;
    private Date effectiveTime;

    public UpdateRecordDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "UpdateRecordDTO{" +
                "id=" + id +
                ", areaCode='" + areaCode + '\'' +
                ", effectiveTime=" + effectiveTime +
                '}';
    }
}
