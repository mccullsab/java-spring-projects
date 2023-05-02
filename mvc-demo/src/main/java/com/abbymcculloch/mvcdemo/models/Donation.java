package com.abbymcculloch.mvcdemo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//allows us to create a table in mysql

@Entity
@Table(name="donations")
public class Donation {
	
//	Id means this is our primary or unique key
    @Id
// 	this auto increments the ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    not null means required = true
    @NotNull
    @Size(min = 2)
    private String donationName;
    
    @NotNull
    @Size(min = 2)
    private String donor;
    
    @NotNull
    @Size(min = 2, message="description must be at least 2 characters")
    private String description;
    
    @NotNull
//    need min instead of size bc it is an integer
    @Min(value = 1, message="quentity must be at least 1")
    private Integer quantity;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
  
//    empty class
    public Donation() {}

//auto generate fields, uncheck id, created and updated at
	public Donation(String donationName, String donor, String description, Integer quantity) {
		this.donationName = donationName;
		this.donor = donor;
		this.description = description;
		this.quantity = quantity;
	}

//	getters and setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDonationName() {
		return donationName;
	}


	public void setDonationName(String donationName) {
		this.donationName = donationName;
	}


	public String getDonor() {
		return donor;
	}


	public void setDonor(String donor) {
		this.donor = donor;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
//	created and update
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    

    
    
    
    
    
    
    
}
