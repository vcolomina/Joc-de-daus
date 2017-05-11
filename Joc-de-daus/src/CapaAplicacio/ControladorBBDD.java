package CapaAplicacio;

import CapaPersistencia.LoginBBDD;

public class ControladorBBDD {

	public ControladorBBDD(String user, String password) throws Exception{

		LoginBBDD.login(user, password);
		
	}
	
}
