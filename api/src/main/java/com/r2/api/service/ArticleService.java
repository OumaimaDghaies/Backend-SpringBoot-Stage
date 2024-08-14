package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.Article;

public interface ArticleService {
    Article postArticle(Article article) throws Exception;
    List<Article> getArticle() throws Exception;
    Article putArticle (Integer id , Article article) throws Exception;
    String deleteArticle (Integer id) throws Exception;
    Article getArticleById(Integer id);

}
