package me.lv.record.entity.dto;

/**
 * @author lv
 */
public class SearchDTO {
    private String title;
    private String areaCode;
    private Integer page;
    private Integer pageSize;

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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "title='" + title + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
