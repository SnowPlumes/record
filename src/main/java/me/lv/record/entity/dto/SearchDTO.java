package me.lv.record.entity.dto;

/**
 * @author Elv
 */
public class SearchDTO {
    private String title;
    private String region;

    public SearchDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "title='" + title + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
