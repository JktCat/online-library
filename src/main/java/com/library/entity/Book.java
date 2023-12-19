package com.library.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	@Column
	private String author;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@Column(name = "pages_number")
	private int pagesNumber;
	@Column(name = "quantity_sold")
	private int quantitySold;
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	@Column(name = "image", columnDefinition = "TEXT")
	private String image;
	@Column
	private float price;
	@Column
	private String category;
	
	@OneToMany(mappedBy = "book")
    private Set<Booking> bookings;
	
	public Book() {
		
	}

	public Book(String title, String author, Date date, int pagesNumber, int quantitySold, String description,
			String image, float price, String category) {
		super();
		this.title = title;
		this.author = author;
		this.date = date;
		this.pagesNumber = pagesNumber;
		this.quantitySold = quantitySold;
		this.description = description;
		this.image = image;
		this.price = price;
		this.category = category;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPagesNumber() {
		return pagesNumber;
	}
	public void setPagesNumber(int pagesNumber) {
		this.pagesNumber = pagesNumber;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	public int updateQuantity(int q) {
		return this.quantitySold + q;
	}
	
}
