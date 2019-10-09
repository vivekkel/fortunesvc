
package com.fortune.travels.model;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ExpensesReqRes {
	
	private List<Expenses> expenses;
	@NotNull
	private FilterCriteria filterCriteria;
	private String errorMessage;
	private boolean isSucessful;
	
	public List<Expenses> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expenses> expenses) {
		this.expenses = expenses;
	}
	public FilterCriteria getFilterCriteria() {
		return filterCriteria;
	}
	public void setFilterCriteria(FilterCriteria filterCriteria) {
		this.filterCriteria = filterCriteria;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public boolean isSucessful() {
		return isSucessful;
	}
	public void setSucessful(boolean isSucessful) {
		this.isSucessful = isSucessful;
	}
}
