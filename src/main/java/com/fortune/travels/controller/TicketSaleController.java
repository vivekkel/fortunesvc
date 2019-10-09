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
import com.fortune.travels.model.FilterCriteria;
import com.fortune.travels.model.TicketSaleReqRes;
import com.fortune.travels.model.TicketSales;
import com.fortune.travels.repository.TicketSaleDAOService;
import com.fortune.travels.repository.TicketSalesRepository;

@RestController
@RequestMapping("/fortune")
public class TicketSaleController {
	
	@Autowired
	TicketSaleDAOService ticketSaleDAOService;
	
	@Autowired
	TicketSalesRepository TicketSalesRepository;
	
	@PostMapping("/ticketSales")
	public TicketSaleReqRes TicketSales(@Valid @RequestBody TicketSaleReqRes ticketSaleReqRes){
		TicketSaleReqRes ticketSaleResponse = new TicketSaleReqRes();
		try {
			if(null != ticketSaleReqRes && null != ticketSaleReqRes.getTicketSaleList() 
					&& ticketSaleReqRes.getTicketSaleList().size() > 0 ) {
				
				for(TicketSales ticketSales: ticketSaleReqRes.getTicketSaleList()) {
					if(ticketSales.getChangeType() == ChangeType.INSERT) {
						if(null == ticketSales.getInvoiceId() || ticketSales.getInvoiceId() == 0) {
							ticketSales.setInvoiceId(null);
							ticketSales.setCreatedAt(new Date());
							ticketSales.setUpdatedAt(new Date());
							TicketSalesRepository.save(ticketSales);
						}
					}
					else if(ticketSales.getChangeType() == ChangeType.UPDATE) {
						ticketSales.setUpdatedAt(new Date());
						TicketSalesRepository.save(ticketSales);
					}
					else if(ticketSales.getChangeType() == ChangeType.REMOVE) {
						TicketSalesRepository.delete(ticketSales);
					}
				}
			}
			ticketSaleResponse.setFilterCriteria(ticketSaleReqRes.getFilterCriteria());
			ticketSaleResponse.setTicketSaleList(ticketSaleDAOService.selectAllTicketSalesCriteria(ticketSaleReqRes.getFilterCriteria()));
		}
		catch(Exception e) {
			ticketSaleReqRes.setSucessful(false);
			ticketSaleReqRes.setErrorMessage(e.getMessage());
			return ticketSaleReqRes;
		}
		ticketSaleResponse.setSucessful(true);
		return ticketSaleResponse;
	}
	
	@GetMapping("/getAllTicketSales")
	public TicketSaleReqRes getAllTicketSales(){
		TicketSaleReqRes ticketSaleReqRes = new TicketSaleReqRes();
		FilterCriteria filterCriteria = new FilterCriteria();
		filterCriteria.setStartDate((long) 20190826);
		filterCriteria.setEndDate((long) 20190826);
		ticketSaleReqRes.setFilterCriteria(filterCriteria);
		ticketSaleReqRes.setTicketSaleList(ticketSaleDAOService.selectAllTicketSales());
		return ticketSaleReqRes;
	}
	
	@GetMapping("/getAllTicketSalesCriteria")
	public TicketSaleReqRes getAllTicketSalesCriteria(){
		TicketSaleReqRes ticketSaleReqRes = new TicketSaleReqRes();
		FilterCriteria filterCriteria = new FilterCriteria();
		ticketSaleReqRes.setFilterCriteria(filterCriteria);
		filterCriteria.setStartDate((long) 20190826);
		filterCriteria.setEndDate((long) 20190826);
		ticketSaleReqRes.setSucessful(true);
		ticketSaleReqRes.setTicketSaleList(ticketSaleDAOService.selectAllTicketSalesCriteria(filterCriteria));
		return ticketSaleReqRes;
	}
	
	@GetMapping("/getAllTicketSalesUpdate")
	public TicketSales getAllTicketSalesUpdate(){
		
		TicketSales ticketSales = new TicketSales();
		ticketSales.setInvoiceId((long) 3);
		ticketSales.setAgt("CHANGE");
		ticketSales.setBranchName("FREE");
		ticketSales.setCash(24.000);
		ticketSales.setCls("W");
		ticketSales.setCredit(0);
		ticketSales.setDocNumber("G9 92209798");
		ticketSales.setFare(17.000);
		ticketSales.setName("Rigil");
		ticketSales.setNet(8.000);
		ticketSales.setPcc("5ALA");
		ticketSales.setPercent(2.000);
		ticketSales.setPnr("LUUYET");
		ticketSales.setProfit(11.500);
		ticketSales.setRemarks("Remark");
		ticketSales.setSaleDate(20190826);
		ticketSales.setSuppSC(1.000);
		ticketSales.setTax(2.000);
		ticketSales.setTotal(25.000);
		ticketSales.setUpdatedAt(new Date());
		ticketSales.setCreatedAt(new Date());
		return ticketSaleDAOService.update(ticketSales);
	}
	
	@GetMapping("/ticketSalesRemove")
	public void ticketSalesRemove(){
		ticketSaleDAOService.delete((long)10);
	}
}
