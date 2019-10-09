package com.fortune.travels.model;

import java.util.List;

import javax.validation.constraints.NotNull;

public class TicketSaleReqRes {
	
	private List<TicketSales> ticketSaleList;
	@NotNull
	private FilterCriteria filterCriteria;
	private String errorMessage;
	private boolean isSucessful;
	
	public List<TicketSales> getTicketSaleList() {
		return ticketSaleList;
	}
	public void setTicketSaleList(List<TicketSales> ticketSaleList) {
		this.ticketSaleList = ticketSaleList;
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
