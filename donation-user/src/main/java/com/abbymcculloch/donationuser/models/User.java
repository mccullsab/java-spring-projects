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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//allows us to create a table in mysql

@Entity
@Table(name="users")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 2)
    private String userName;
    
    @Email
    private String email;
    
//    @OneToMany(mappedBy="donor", fetch=FetchType.LAZY)
//    private List<Donation> setDonation;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "recieved_donation", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "donation_id")
    )
    private List<Donation> donations;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	
//    empty class
    public User() {}


//  get and set
    

public Date getCreatedAt() {
		return createdAt;
	}



	public List<Donation> getDonations() {
	return donations;
}


public void setDonations(List<Donation> donations) {
	this.donations = donations;
}


//	public List<Donation> getSetDonation() {
//	return setDonation;
//}
//
//
//
//public void setSetDonation(List<Donation> setDonation) {
//	this.setDonation = setDonation;
//}
//


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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
