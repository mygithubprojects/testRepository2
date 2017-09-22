package com.seedbackend.dao;

import java.util.List;

import org.hibernate.Session;

import com.seedbackend.model.Indice;
import com.seedbackend.util.HibernateUtils;

public abstract class DAO <T>{

	public Session session = HibernateUtils.getSessionFactory().openSession();
	
	/**
	 * Permet de r�cup�rer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T find(long id);
	
	/**
	 * Permet de cr�er une entr�e dans la base de donn�es
	 * par rapport � un objet
	 * @param obj
	 */
	public abstract T create(T obj);
	
	/**
	 * Permet de mettre � jour les donn�es d'une entr�e dans la base 
	 * @param obj
	 */
	public abstract T update(T obj);
	
	/**
	 * Permet la suppression d'une entr�e de la base
	 * @param obj
	 */
	public abstract void delete(T obj);

	/**
	 * Permet de r�cup�rer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract List<T> getAll();

	public abstract T save(T obj);
	
	
}
