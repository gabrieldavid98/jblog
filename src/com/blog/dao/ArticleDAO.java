package com.blog.dao;

import com.blog.entities.Article;

public class ArticleDAO extends BaseDAO<Article> {
   public ArticleDAO() {
      super(Article.class);
   }
}
