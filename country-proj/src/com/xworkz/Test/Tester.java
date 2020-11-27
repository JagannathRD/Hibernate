package com.xworkz.Test;

import com.xworkz.dao.DAOImpl;
import com.xworkz.dao.DAOInterface;
import com.xworkz.dto.CountryDTO;

public class Tester {

	public static void main(String[] args) {
		System.out.println("mms");
		CountryDTO countryDTO= new CountryDTO();
		countryDTO.setName("India");
		countryDTO.setCurrency("Rupees");
		countryDTO.setPopulation(11189781371l);
		
		DAOInterface daoInterface= new DAOImpl();
		
		daoInterface.saveCountry(countryDTO);
		daoInterface.updateCountry(111111123378l, "India");
		daoInterface.deleteByCountry("India");
		
		Object[] objects=daoInterface.getByCurrency(1);
		for (Object object : objects) {
			System.out.println(object);
		} 
		
		String name=daoInterface.getName("Dollar"); 
		
		System.out.println(name);
		
		daoInterface.getTwoCol();
		
		daoInterface.getTable();
		
		System.out.println("mme");
	}

}
