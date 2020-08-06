package fr.afpa.bibliotheque.data;

import java.util.Date;

import lombok.Data;

@Data
public class Utilisateur {
	
	private int id;
	private String title;
	private String category;
	private Date dateMiseEnRayon;

}
