package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Revenue;
import br.com.fiap.bean.User;
import br.com.fiap.exception.DBException;

public interface RevenueDAO {
	
	void insertRevenue(Revenue revenue, User user) throws DBException;
	
	void updateRevenue(Revenue revenue) throws DBException;
	
	void removeRevenue(int idRevenue) throws DBException; 
	
	Revenue getRevenueById(int idRevenue) throws DBException;
	
	List<Revenue> getAllRevenues();

}
