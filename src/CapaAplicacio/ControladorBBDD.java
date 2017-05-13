package CapaAplicacio;

import java.util.List;

import CapaDomini.Partida;
import CapaPersistencia.JugadorBBDD;
import CapaPersistencia.LoginBBDD;
import CapaPersistencia.PartidaBBDD;

public class ControladorBBDD {

	public ControladorBBDD(String user, String password) throws Exception{
		LoginBBDD.login(user, password);
	}
	
	public ControladorBBDD() {}

	public boolean existJugador(String nom) throws Exception{
		return JugadorBBDD.existJugador(nom);
	}
	
	public boolean storeJugador(String nom) throws Exception{
		JugadorBBDD.saveJugador(nom);
		return true;
	}
	
	public List<Partida> getPartides(String nom) throws Exception{
		return PartidaBBDD.getPartides(nom);
		
	}
	
	public void savePartida(String nom, int dau1, int dau2) throws Exception{
		PartidaBBDD.savePartida(nom, dau1, dau2);
	}
	
}
