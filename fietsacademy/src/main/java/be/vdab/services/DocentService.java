package be.vdab.services;

import java.math.BigDecimal;
import java.util.List;

import be.vdab.dao.DocentDAO;
import be.vdab.entities.Docent;
import be.vdab.exceptions.DocentBestaatAlException;
import be.vdab.valueobjects.AantalDocentenPerWedde;
import be.vdab.valueobjects.VoornaamEnId;

public class DocentService {
	private final DocentDAO docentDAO = new DocentDAO();

	public Docent read(long id) {
		return docentDAO.read(id);
	}

	public void create(Docent docent) {
		if (docentDAO.findByRijksRegisterNr(docent.getRijksRegisterNr()) != null) {
			throw new DocentBestaatAlException();
		}
		docentDAO.beginTransaction();
		docentDAO.create(docent);
		docentDAO.commit();
	}

	public void delete(long id) {
		docentDAO.beginTransaction();
		docentDAO.delete(id);
		docentDAO.commit();
	}

	public void opslag(long id, BigDecimal percentage) {
		docentDAO.beginTransaction();
		docentDAO.read(id).opslag(percentage);
		docentDAO.commit();
	}

	public List<Docent> findByWeddeBetween(BigDecimal van, BigDecimal tot,
			int vanafRij, int aantalRijen) {
		return docentDAO.findByWeddeBetween(van, tot, vanafRij, aantalRijen);
	}

	// public List<String> findVoornamen() {
	// return docentDAO.findVoornamen();
	// }

	public List<VoornaamEnId> findVoornamen() {
		return docentDAO.findVoornamen();
	}

	public BigDecimal findMaxWedde() {
		return docentDAO.findMaxWedde();
	}

	public List<AantalDocentenPerWedde> findAantalDocentenPerWedde() {
		return docentDAO.findAantalDocentenPerWedde();
	}

	public void algemeneOpslag(BigDecimal percentage) {
		BigDecimal factor = BigDecimal.ONE.add(percentage.divide(BigDecimal
				.valueOf(100)));
		docentDAO.beginTransaction();
		docentDAO.algemeneOpslag(factor);
		docentDAO.commit();
	}

	public void bijnaamToevoegen(long id, String bijnaam) {
		docentDAO.beginTransaction();
		docentDAO.read(id).addBijnaam(bijnaam);
		docentDAO.commit();
	}

	public void bijnamenVerwijderen(long id, Iterable<String> bijnamen) {
		docentDAO.beginTransaction();
		Docent docent = docentDAO.read(id);
		for (String bijnaam : bijnamen) {
			docent.removeBijnaam(bijnaam);
		}
		docentDAO.commit();
	}

}
