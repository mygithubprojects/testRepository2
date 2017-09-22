package com.seedbackend.dao;

import java.util.List;

import com.seedbackend.dto.IndiceDTO;
import com.seedbackend.model.Indice;

public class IndiceDAO extends DAO<Indice> {

	@Override
	public Indice find(long id) {
		Indice indice = (Indice) session.get(Indice.class,id);
		session.close();
		return indice;
	}

	@Override
	public Indice create(Indice indice) {
		session.save(indice);
		return  (Indice) session.merge(indice);
	}

	@Override
	public Indice save(Indice indice) {
		Indice indiceToUpdate = (Indice) session.get(Indice.class,2l);
		session.save(indice);
		return  (Indice) session.merge(indice);
	}

	@Override
	public void delete(Indice obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Indice> getAll() {
		List<Indice> indices = session.createQuery("FROM Indice").list();
		session.close();
		return indices;
	}
	
	// create an IndiceDTO from an Indice 
	public IndiceDTO createIndiceDTO (Indice indice) {
		IndiceDTO indiceDTO = new IndiceDTO();
		
		indiceDTO.setId(indice.getId());
		indiceDTO.setChampA (indice.getChampA());
		indiceDTO.setChampB (indice.getChampB());
		indiceDTO.setChampC (indice.getChampC());
		indiceDTO.setIndicateur1 (indice.getIndicateur1());
		indiceDTO.setModif1 (indice.getModif1());
		indiceDTO.setIndicateur1 (indice.getIndicateur1());
		indiceDTO.setModif2 (indice.getModif2());
		
		return indiceDTO;
	}
	
	// create an Indice from an IndiceDTO 
	public Indice createIndiceBEAN (IndiceDTO indiceDTO) {
		Indice indice = new Indice();
		
		indice.setId(indiceDTO.getId());
		indice.setChampA (indiceDTO.getChampA());
		indice.setChampB (indiceDTO.getChampB());
		indice.setChampC (indiceDTO.getChampC());
		indice.setIndicateur1 (indiceDTO.getIndicateur1());
		indice.setModif1 (indiceDTO.getModif1());
		indice.setIndicateur1 (indiceDTO.getIndicateur1());
		indice.setModif2 (indiceDTO.getModif2());
		
		return indice;
	}

	@Override
	public Indice update(Indice obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
