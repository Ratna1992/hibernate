package com.ratna.hibernate.pojo;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "author")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Author {

	@Id
	@GeneratedValue
	private Integer bookId;
	@Column
	private String title;
	@Column
	private Integer price;
	@Column
	private String description;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Author [bookId=" + bookId + ", title=" + title + ", price=" + price + ", description=" + description
				+ "]";
	}

}
