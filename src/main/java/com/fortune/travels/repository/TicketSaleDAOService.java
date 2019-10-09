package com.fortune.travels.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fortune.travels.model.FilterCriteria;
import com.fortune.travels.model.TicketSales;

@Repository
@Transactional
public class TicketSaleDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public TicketSales insert (TicketSales ticketSales) {
		 entityManager.persist(ticketSales);
		 return ticketSales;
	}
	
	public TicketSales update (TicketSales ticketSales) {
		return entityManager.merge(ticketSales);
	}
	
	public void delete (Long invoiceId) {
		 entityManager.remove(findTicketSales(invoiceId));
	}
	
	public TicketSales findTicketSales (Long invoiceId) {
		return entityManager.find(TicketSales.class, invoiceId);
	}
	
	public List<TicketSales> selectAllTicketSalesCriteria (FilterCriteria filterCriteria) {
		 Query query = entityManager.createQuery("SELECT t FROM TicketSales t "
		 		+ "where t.saleDate >= "+filterCriteria.getStartDate()+ " and t.saleDate <= " +filterCriteria.getEndDate());
 		 
		 return (List<TicketSales>) query.getResultList();
	}
	
	public List<TicketSales> selectAllTicketSales () {
		 Query query = entityManager.createQuery("SELECT ts FROM TicketSales ts");
		 return (List<TicketSales>) query.getResultList();
	}
}
