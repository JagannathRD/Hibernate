package com.xworkz.dto;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@NamedQueries({
	@NamedQuery(name = "updatePop", query = "update CountryDTO set population=:pop where name=:count "),
	@NamedQuery(name="deleteByCountry", query="delete CountryDTO dto where dto.name=:count"),
	@NamedQuery(name="getByCurrency", query="select name,currency from CountryDTO where id=:id "),
	@NamedQuery(name="getName", query="select name from CountryDTO where currency=:cu " ),
	@NamedQuery(name="getTwoCol", query="select name, currency from CountryDTO"),
	@NamedQuery(name="getTable", query="from CountryDTO")
})
@Table(name="country_table") 
public class CountryDTO implements Serializable {

	@Id
	@GenericGenerator(name="ref", strategy="increment" )
	@GeneratedValue(generator="ref")
	@Column(name="country_id")
	private int id;
	@Column(name="country_name")
	private String name;
	@Column(name="country_population")
	private long population;
	@Column(name="country_currency")
	private String currency;

	public CountryDTO() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "CountryDTO [id=" + id + ", name=" + name + ", population=" + population + ", currency=" + currency
				+ "]";
	}
}
