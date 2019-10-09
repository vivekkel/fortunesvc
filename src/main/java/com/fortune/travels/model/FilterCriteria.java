package com.fortune.travels.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FilterCriteria {
	
	@NotNull
	@Min(value=0, message = "Start date should not be zero")
	Long startDate;
	
	@NotNull
	@Min(value=0, message = "End date should not be zero")
	Long endDate;
	
	public Long getStartDate() {
		return startDate;
	}
	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}
	public Long getEndDate() {
		return endDate;
	}
	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}
}
