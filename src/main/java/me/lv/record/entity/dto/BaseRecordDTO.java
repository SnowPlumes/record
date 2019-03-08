package me.lv.record.entity.dto;

/**
 * @author lv
 */
public class BaseRecordDTO {
    private Integer recordId;
    private String title;
    private String name;
    private String phone;
    private String address;
    private Double amount;
    private String picture;


    public BaseRecordDTO() {
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "BaseRecordDTO{" +
                "recordId=" + recordId +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", picture='" + picture + '\'' +
                '}';
    }
}
