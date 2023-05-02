package com.abbymcculloch.donationuser.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "recieved_donation", 
        joinColumns = @JoinColumn(name = "donation_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
    
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


//	getters and setters
    
    

	public Long getId() {
		return id;
	}




	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
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
