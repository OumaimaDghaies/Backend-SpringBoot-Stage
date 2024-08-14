package com.r2.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.r2.api.modeles.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
    @Query("SELECT a FROM Article a LEFT JOIN FETCH a.famille LEFT JOIN FETCH a.sousfamille")
    List<Article> findAllArticlesWithDetails();

}
