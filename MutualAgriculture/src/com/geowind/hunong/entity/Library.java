package com.geowind.hunong.entity;

import java.util.List;

/**
 * Created by Kui on 2016/7/27.
 */
public class Library {

    private List<Article> articleList;

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "articleList=" + articleList +
                '}';
    }
}
