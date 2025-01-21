package com.enotes.entity;

import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Notes extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	@ManyToOne
	private Category category;

	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notes(Boolean isActive, Boolean isDeleted, Integer createdBy, Date createdOn, Integer updatedBy,
			Date updatedOn) {
		super(isActive, isDeleted, createdBy, createdOn, updatedBy, updatedOn);
		// TODO Auto-generated constructor stub
	}

	public Notes(Boolean isActive, Boolean isDeleted, Integer createdBy, Date createdOn, Integer updatedBy,
			Date updatedOn, Integer id, String title, String description, Category category) {
		super(isActive, isDeleted, createdBy, createdOn, updatedBy, updatedOn);
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
