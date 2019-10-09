package com.fortune.travels.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fortune.travels.model.Expenses;
import com.fortune.travels.model.FilterCriteria;

@Repository
@Transactional
public class ExpensesDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Expenses insert (Expenses expenses) {
		entityManager.persist(expenses);
		return expenses;
	}
	
	public Expenses update (Expenses expenses) {
		entityManager.merge(expenses);
		return expenses;
	}
	
	public void  delete (Expenses expenses) {
		entityManager.remove(findExpense(expenses.getExpenceId()));
	}
	
	public Expenses  findExpense (Long expenseId) {
		return entityManager.find(Expenses.class,expenseId);
	}
	
	public List<Expenses> selectAllExpenseCriteria(FilterCriteria filterCriteria){
		Query query = entityManager.createQuery("SELECT e FROM Expenses e "
				+ "where e.expenceDate >= "+filterCriteria.getStartDate()+ " and " +" e.expenceDate <= "+filterCriteria.getEndDate());
		
		return (List<Expenses>) query.getResultList();
	}
	
	public List<Expenses> selectAllExpense(){
		Query query = entityManager.createQuery("SELECT e FROM Expenses e ");
		return (List<Expenses>) query.getResultList();
	}
}
