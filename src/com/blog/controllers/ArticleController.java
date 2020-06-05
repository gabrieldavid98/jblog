package com.blog.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.blog.entities.Article;

@Named
@RequestScoped
public class ArticleController {
   private List<Article> articles;
   private String title;
   private String body;
   
   @PostConstruct
   public void init() {
      articles = new ArrayList<Article>();
      articles.add(new Article("First Article", "This is the first article :D"));
      articles.add(new Article("Second Article", "This is the second article :D"));
      articles.add(new Article("Third Article", "This is the third article :D"));
   }

   public List<Article> getArticles() {
      return articles;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getBody() {
      return body;
   }

   public void setBody(String body) {
      this.body = body;
   }
   
   public void save() {
   }
}
