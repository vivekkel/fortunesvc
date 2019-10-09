package com.fortune.travels.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "expenses")
@EntityListeners(AuditingEntityListener.class)

public class Expenses {
	
	public Expenses() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="expence_Id")
	private Long expenceId;

    @Column(name = "expence_date", nullable = false)
	private int expenceDate;
    
    @JsonInclude()
    @Transient
    int changeType;
    
    private String particulars;
    
    private String category;
    
    private String amount;
    
	@Column(name = "branch")
	private String branchName;
    
    private Date createdAt;

    private Date updatedAt;

	public Long getExpenceId() {
		return expenceId;
	}

	public void setExpenceId(Long expenceId) {
		this.expenceId = expenceId;
	}

	public int getExpenceDate() {
		return expenceDate;
	}

	public void setExpenceDate(int expenceDate) {
		this.expenceDate = expenceDate;
	}

	public int getChangeType() {
		return changeType;
	}

	public void setChangeType(int changeType) {
		this.changeType = changeType;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
       
}
