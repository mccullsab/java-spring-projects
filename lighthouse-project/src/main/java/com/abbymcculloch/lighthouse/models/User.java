package com.abbymcculloch.lighthouse.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty(message="Username is required!")
	    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
	    private String userName;
	    
	    @NotEmpty(message="Email is required!")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @NotEmpty(message="Password is required!")
	    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	    private String password;
	    
	    @Transient
	    @NotEmpty(message="Confirm Password is required!")
	    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	    private String confirm;
	    
	    
	    // use userservice
	    
	    
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    @OneToMany(mappedBy="to_user", fetch=FetchType.LAZY)
	    private List<Message> setToMessage;
	    
	    @OneToMany(mappedBy="from_user", fetch=FetchType.LAZY)
	    private List<Message> setFromMessage;
	    
	   private String city;
	   private String book;
	   private Boolean privacy;
	   
	  
	  
	    public User() {}
	    
	    
	    
	    
		public Boolean getPrivacy() {
			return privacy;
		}




		public void setPrivacy(Boolean privacy) {
			this.privacy = privacy;
		}




		public List<Message> getSetToMessage() {
			return setToMessage;
		}




		public void setSetToMessage(List<Message> setToMessage) {
			this.setToMessage = setToMessage;
		}




		public List<Message> getSetFromMessage() {
			return setFromMessage;
		}




		public void setSetFromMessage(List<Message> setFromMessage) {
			this.setFromMessage = setFromMessage;
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




		public String getPassword() {
			return password;
		}




		public void setPassword(String password) {
			this.password = password;
		}




		public String getConfirm() {
			return confirm;
		}




		public void setConfirm(String confirm) {
			this.confirm = confirm;
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



		public String getCity() {
			return city;
		}




		public void setCity(String city) {
			this.city = city;
		}




		public String getBook() {
			return book;
		}




		public void setBook(String book) {
			this.book = book;
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
