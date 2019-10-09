package com.fortune.travels.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortune.travels.model.ChangeType;
import com.fortune.travels.model.Expenses;
import com.fortune.travels.model.ExpensesReqRes;
import com.fortune.travels.repository.ExpensesDAOService;
import com.fortune.travels.repository.ExpensesRepository;

@RestController
@RequestMapping("/fortune")
public class ExpensesController {
	
	@Autowired
	ExpensesDAOService expensesDAOService;
	
	@Autowired
	ExpensesRepository expensesRepository;
	
	@PostMapping("/expenses")
	public ExpensesReqRes expenses(@Valid @RequestBody ExpensesReqRes expensesReqRes) {
		ExpensesReqRes expensesResponse = new ExpensesReqRes();
		expensesResponse.setSucessful(true);
		try {
			if(null != expensesReqRes && null != expensesReqRes.getExpenses()
				&& 	expensesReqRes.getExpenses().size() > 0) {
				for(Expenses expense : expensesReqRes.getExpenses()) {
					if(expense.getChangeType() == ChangeType.INSERT) {
						if(null == expense.getExpenceId() || expense.getExpenceId() == 0) {
							expense.setExpenceId(null);
							expense.setCreatedAt(new Date());
							expense.setUpdatedAt(new Date());
							expensesRepository.save(expense);
						}
					}
					else if(expense.getChangeType() == ChangeType.UPDATE) {
						expense.setUpdatedAt(new Date());
						expensesRepository.save(expense);
					}
					else if(expense.getChangeType() == ChangeType.REMOVE) {
						expensesRepository.delete(expense);
					}
				}
			}
			expensesResponse.setFilterCriteria(expensesReqRes.getFilterCriteria());
			expensesResponse.setExpenses(expensesDAOService.selectAllExpenseCriteria(expensesReqRes.getFilterCriteria()));
		}
		catch(Exception e) {
			expensesResponse.setSucessful(false);
			expensesResponse.setErrorMessage(e.getMessage());
			return expensesResponse;
		}
		return expensesResponse;
	}
	
	@GetMapping("/getExpenses")
	public ExpensesReqRes getExpenses() {
		ExpensesReqRes expensesReqRes= new ExpensesReqRes(); 
		expensesReqRes.setExpenses(expensesDAOService.selectAllExpense());
		return expensesReqRes;
	}
}
