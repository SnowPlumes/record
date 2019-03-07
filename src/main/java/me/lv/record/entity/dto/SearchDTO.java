package me.lv.record.entity.dto;

/**
 * @author lv
 */
public class SearchDTO {
    private String title;
    private String areaCode;

    public SearchDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "title='" + title + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
