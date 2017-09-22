package com.seedbackend.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import com.seedbackend.dao.IndiceDAO;
import com.seedbackend.dto.IndiceDTO;
import com.seedbackend.model.Indice;


public class IndiceService {

	@Inject
	private IndiceDAO indiceDAO; 
	

	public  IndiceDTO get(long id) {
		Indice indice;
		indice =  indiceDAO.find(id);
		return indiceDAO.createIndiceDTO(indice);
	}    
	
	
	public  IndiceDTO save(IndiceDTO indiceDTO) {
		Indice savedIndice = new Indice();
		savedIndice = indiceDAO.createIndiceBEAN(indiceDTO);
		return indiceDAO.createIndiceDTO(savedIndice);
	} 
	
	public  List <Indice> getAll() {
		return indiceDAO.getAll();
	}    
	
	public  List <Indice> create(Indice indice) {
		indiceDAO.create(indice);
		return indiceDAO.getAll();
	} 	
	
	/**
	 * bouchon de donn�es pour les tests
	 * @return
	 */
	public List<Indice> bouchonDonnee () {
		List <Indice> liste = new ArrayList <Indice>();
		Indice  indice1, indice2, indice3,indice4,indice5,indice6, indice7;
		indice1 = new Indice(1l, "A1", "A1", "C1", "D4", "15", "15", "15", "15");
		indice2 = new Indice(2l, "A2", "A2", "C2", "D2", "22", "22", "22", "22");
		indice3 = new Indice(3l, "A3", "A3", "C3", "D3", "33", "33", "33", "33");
		indice4 = new Indice(4l, "A4", "A4", "C4", "D4", "15", "15", "15", "15");
		indice5 = new Indice(5l, "A5", "A5", "C5", "D5", "15", "15", "15", "15");
		indice6 = new Indice(6l, "A6", "A6", "C6", "D6", "15", "15", "15", "15");
		indice7 = new Indice(7l, "A7", "A7", "C7", "D7", "15", "15", "15", "15");

		liste.add(indice1);
		liste.add(indice2);
		liste.add(indice3);
		liste.add(indice4);
		liste.add(indice5);
		liste.add(indice6);
		liste.add(indice7);

		return liste;

	}
}
