package com.recell.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	
	@Column(name="discount_price")
	private int discountPrice;
	
	
	@Column(name="discount_percent")
	private int discountPercent;
	
	private int quantity;
	
	private String brand;
	
	private String color;
	
	@Embedded
	@ElementCollection
	@Column(name="storage")
	private Set<Storage> storage=new HashSet<>();
	
	
	@Column(name="image_url")
	private String imageUrl;
	
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rating> rating = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews=new ArrayList<>();
	
	
	@Column(name="num_ratings")
	private int numRatings;
	
	
	@ManyToOne()
	@JoinColumn(name="catagory_id")
	private Category category;
	

	private LocalDateTime createdAt;
	
	
	
	public Product() {
		
	}



	public Product(Long id, String title, String description, int price, int discountPrice, int discountPercent,
			int quantity, String brand, String color, Set<Storage> storage, String imageUrl, List<Rating> rating,
			List<Review> reviews, int numRatings, Category category, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discountPrice = discountPrice;
		this.discountPercent = discountPercent;
		this.quantity = quantity;
		this.brand = brand;
		this.color = color;
		this.storage = storage;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.reviews = reviews;
		this.numRatings = numRatings;
		this.category = category;
		this.createdAt = createdAt;
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getDiscountPrice() {
		return discountPrice;
	}



	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}



	public int getDiscountPercent() {
		return discountPercent;
	}



	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public Set<Storage> getStorage() {
		return storage;
	}



	public void setStorage(Set<Storage> storage) {
		this.storage = storage;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public List<Rating> getRating() {
		return rating;
	}



	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}



	public List<Review> getReviews() {
		return reviews;
	}



	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}



	public int getNumRatings() {
		return numRatings;
	}



	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}



	public Category getCatagory() {
		return category;
	}



	public void setCatagory(Category category) {
		this.category = category;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

}