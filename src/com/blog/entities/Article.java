package com.blog.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="article_id")
	private int articleId;

	@Lob
	private String body;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String title;

	public Article() {
	}
	
	public Article(String title, String body) {
      super();
      this.body = body;
      this.title = title;
   }

   public int getArticleId() {
		return this.articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}