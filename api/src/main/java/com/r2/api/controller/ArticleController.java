package com.r2.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2.api.modeles.Article;
import com.r2.api.service.ArticleService;
import com.r2.api.service.FamilyService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/article")
@AllArgsConstructor

public class ArticleController {
    ArticleService articleService;
    FamilyService familyService;

    @GetMapping("/read/{id}")
    public Article getArticleById(@PathVariable Integer id) {
        return articleService.getArticleById(id);
    }
    //Creates a new article
      @PostMapping("/create")
    public ResponseEntity<Article> create(@RequestBody Article article) throws Exception{
        try {
            Article createdDetails = articleService.postArticle(article);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Retrieves all article
    @GetMapping("/read")
    public ResponseEntity<List<Article>> read() {
        try{
        List<Article> lstf=articleService.getArticle();
        System.out.println(lstf);
        return new ResponseEntity<>(articleService.getArticle(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing article
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteArticle(@PathVariable Integer id) {
    try {
        articleService.deleteArticle(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Article supprimé");
    return ResponseEntity.ok(response);
}

}
