package com.abbymcculloch.lighthouse.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="messages")

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="to_user_id")
    private User to_user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="from_user_id")
    private User from_user;
    
    @NotNull
    @Size(min = 1, message="message must be at least 1 character")
    private String message;
    
    private Integer vote;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
  
    public Message() {}




    public Integer getVote() {
		return vote;
	}




	public void setVote(Integer vote) {
		this.vote = vote;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public User getTo_user() {
		return to_user;
	}




	public void setTo_user(User to_user) {
		this.to_user = to_user;
	}




	public User getFrom_user() {
		return from_user;
	}




	public void setFrom_user(User from_user) {
		this.from_user = from_user;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
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




	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Boolean isMessageAvailable() {
    	LocalDateTime yesterday = LocalDate.now().atTime(21, 0).minusDays(1);
    	LocalDateTime createdAt = LocalDateTime.ofInstant(this.getCreatedAt().toInstant(), ZoneId.systemDefault());

    	Boolean delay = createdAt.isAfter(yesterday);
    	return delay; 
    }
    
}
