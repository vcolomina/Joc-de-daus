package CapaAplicacio;

import java.util.ArrayList;
import java.util.List;

import CapaAplicacio.DTO.JugadorDTO;
import CapaAplicacio.DTO.PartidaDTO;
import CapaDomini.Dau;
import CapaDomini.Jugador;
import CapaDomini.Partida;

public class ControladorJocDaus {

    private Dau dau1, dau2;
    private final int CARES_DAUS = 6;
    private Jugador jugador;
 
    public ControladorJocDaus() {
        dau1 = new Dau(CARES_DAUS);
        dau2 = new Dau(CARES_DAUS);
        jugador = new Jugador("Anonim");       
    }

    public void jugar() {
        int tirada1 = this.tirarDau(dau1);
        int tirada2 = this.tirarDau(dau2);
        jugador.addPartida(tirada1, tirada2);
    }

    private int tirarDau(Dau dau) {
        dau.llenca();
        return dau.valorCara();
    }

    public JugadorDTO getJugadorDTO() {
    	return new JugadorDTO(jugador);
    }
    
    public String getNomJugador() {
        return jugador.getNom();
    }

    public double guanyadesPercent() {
    	return jugador.nombreGuanyades() / (float) jugador.nombrePartides() * 100;
    }
    
    public PartidaDTO getPartidaEnCurs() {
        return new PartidaDTO(jugador.getPartidaEnCurs());
    }

    public void nouJugador(String nom) throws Exception {
        //Si el nom �s "Anonim" no cal fer res
        if (!nom.equalsIgnoreCase("Anonim")) {          
               jugador = new Jugador(nom);            
        }
    }

    public List<PartidaDTO> getPartides() {
        List <Partida> partides = jugador.getPartides();
        
        List<PartidaDTO> result = new ArrayList<>();
        
        for (Partida p : partides){
        	result.add(new PartidaDTO(p));
        }
        
        return result;
    }
        
}
