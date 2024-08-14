package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Article;
import com.r2.api.repository.ArticleRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    
    ArticleRepository articleRepository;
    
    @Override
    public Article postArticle(Article article) throws Exception {
        try{
            return articleRepository.save(article);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } }

    @Override
    public List<Article> getArticle() throws Exception {
        return articleRepository.findAll();
     }

    

    @Override
    public Article putArticle(Integer id, Article article) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putArticle'");
    }

    @Override
    @Transactional
    public String deleteArticle(Integer id) throws Exception {
        try{
            articleRepository.deleteById(id);
            return "Article supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}

    @Override

    public Article getArticleById(Integer id) {
        return articleRepository.findById(id).orElse(null);
    }

}
