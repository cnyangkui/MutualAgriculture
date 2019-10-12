package com.geowind.hunong.entity;

/**
 * Created by Kui on 2016/7/23.
 */
public class Article {
    //编号
    private int id;
    //类别
    private int category;
    //标题
    private String title;
    //url
    private String url;
    //头部
    private String headContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeadContent() {
        return headContent;
    }

    public void setHeadContent(String headContent) {
        this.headContent = headContent;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", headContent='" + headContent + '\'' +
                '}';
    }
}
