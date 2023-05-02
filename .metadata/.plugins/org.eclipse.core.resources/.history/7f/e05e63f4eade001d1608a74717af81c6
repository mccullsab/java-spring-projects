package com.abbymcculloch.blackbelt.models;


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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="names")
public class Name {
	
//	Id means this is our primary or unique key
    @Id
// 	this auto increments the ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    not null means required = true
    @NotNull
    @Size(min = 2)
    private String babyName;
    
    @NotNull
    private String gender;
    
    @NotNull
    @Size(min = 1, message="origin is required")
    private String origin;
    
//    private Integer votes;
    
    @NotNull
    @Size(min = 2, message="meaning must be at least 2 characters")
    private String meaning;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "votes",
        joinColumns = @JoinColumn(name = "name_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
  
//    empty class
    public Name() {}

    
    
    
    
	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public List<User> getUsers() {
		return users;
	}





	public void setUsers(List<User> users) {
		this.users = users;
	}





	public String getBabyName() {
		return babyName;
	}




	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getOrigin() {
		return origin;
	}




	public void setOrigin(String origin) {
		this.origin = origin;
	}



//
//	public Integer getVotes() {
//		return votes;
//	}
//
//
//
//
//	public void setVotes(Integer votes) {
//		this.votes = votes;
//	}
//
//


	public String getMeaning() {
		return meaning;
	}




	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}




//	public User getUser() {
//		return user;
//	}
//
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}




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
    
    
    // Function to check if the provided userId has voted on this name 
    public Boolean hasUserVoted(Long userId) {
    	System.out.println(userId);
    	// Loop through this.users, if user.id == userId, return true
    	for(int i=0; i<this.users.size(); i++) {
//    		System.out.println("=="+this.users.get(i).getId());
//    		System.out.println("...."+ (this.users.get(i).getId() == userId));
    		if(this.users.get(i).getId().equals(userId)) {
//    			System.out.println("true");
    			return true;
    		}
    	}

    	// Otherwise return false
    	return false;
    }
    
    
    
    
}
