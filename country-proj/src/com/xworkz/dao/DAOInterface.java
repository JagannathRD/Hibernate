package com.xworkz.dao;

import java.util.List;

import com.xworkz.dto.CountryDTO;

public interface DAOInterface {

	void saveCountry(CountryDTO country );
	void updateCountry(long population, String country);
	void deleteByCountry(String country);
	Object[] getByCurrency( int id);
	String getName(String currency);
	List<Object[]> getTwoCol();
	List<CountryDTO> getTable();
	
}
