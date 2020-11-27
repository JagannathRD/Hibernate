package com.xworkz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.xworkz.dto.CountryDTO;

public class DAOImpl implements DAOInterface {
	SessionFactory factory;
	StandardServiceRegistry registry;

	@Override
	public void saveCountry(CountryDTO countryDTO) {

		Session session = null;

		try {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(registry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			factory = metadata.getSessionFactoryBuilder().build();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(countryDTO);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
			if(factory!=null)
				factory.close();
		}

	}

	@Override
	public void updateCountry(long population, String country) {
		Session session = null;

		try {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(registry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			factory = metadata.getSessionFactoryBuilder().build();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Query quey = session.getNamedQuery("updatePop");
			quey.setParameter("pop", population);
			quey.setParameter("count", country);
			quey.executeUpdate();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
			if(factory!=null)
				factory.close();
		}

	}

	@Override
	public void deleteByCountry(String country) {
		Session session = null;
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			factory = metadata.getSessionFactoryBuilder().build();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByCountry");
			query.setParameter("count", country);
			query.executeUpdate();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if(factory!=null)
				factory.close();
		}

	}

	@Override
	public Object[] getByCurrency(int id) {
		Session session = null;
		Object[] countryDTOs = null;
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			factory = metadata.getSessionFactoryBuilder().build();
			session = factory.openSession();

			Query query = session.getNamedQuery("getByCurrency");
			query.setParameter("id", id);
			countryDTOs = (Object[]) query.uniqueResult();

		} catch (Exception e) {

		} finally {
			if (session != null)
				session.close();
			if(factory!=null)
				factory.close();
		}
		return countryDTOs;
	}

	@Override
	public String getName(String currency) {
		String countryName = null;
		Session session = null;

		try {

			Configuration configuration = new Configuration();
			configuration.configure();
			factory = configuration.buildSessionFactory();
			session = factory.openSession();

			Query query = session.getNamedQuery("getName");
			query.setParameter("cu", currency);
			countryName = (String) query.uniqueResult();

		} catch (Exception e) {

		}finally {
			if(session !=null )
				session.close();
			if(factory!=null)
				factory.close();
		}
		return countryName;
	}

	@Override
	public List<Object[]> getTwoCol(){
		Session session = null;
		List<Object[]> list = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			Query query = session.getNamedQuery("getTwoCol");
			list = query.list();
			for (Object[] objects : list) {
				for (Object object : objects) {
					System.out.print(object + " ");
				}
				System.out.println(" ");
			}
		} catch (Exception e) {

		}
		finally {
			if(session !=null )
				session.close();
			if(factory!=null)
				factory.close();
		}
		return list;
	}
	
	@Override
	public List<CountryDTO> getTable(){
		Session sess=null;
		List<CountryDTO> countryDTOs = null;
		try {
			Configuration configuration= new Configuration();
			configuration.configure();
			factory=configuration.buildSessionFactory();
			sess=factory.openSession();
			Query query=sess.getNamedQuery("getTable");
			countryDTOs=query.list();
			System.out.println(countryDTOs);
			
		} catch (Exception e) {
			
					}finally {
						if(sess!=null)
							sess.close();
						if(factory!=null)
							factory.close();
					} 
		return countryDTOs;
		
	}

}
