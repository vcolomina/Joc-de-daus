package CapaAplicacio.DTO;

import java.util.ArrayList;
import java.util.List;

import CapaDomini.Jugador;
import CapaDomini.Partida;

public class JugadorDTO {

	private String nom;
    private List<PartidaDTO> partides;
	
    public JugadorDTO (Jugador jugador){
    	
    	this.nom = jugador.getNom();
    }
}
