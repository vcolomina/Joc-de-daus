package CapaPersistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CapaDomini.Jugador;
import CapaDomini.Partida;

public class PartidaBBDD {

	public static void savePartida(String nom, int dau1, int dau2) throws Exception {

		ConnectionBBDD connection = LoginBBDD.getConnection();
		
		try {

			String sql = "INSERT INTO PARTIDA VALUES(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, nom);
			pst.setInt(2, dau1);
			pst.setInt(3, dau2);
			pst.setInt(4, 0);
			
			if (pst.executeUpdate() != 1) {
				throw new Exception("Partida no guardada");
			}
			
			
		} catch (SQLException e) {
			throw new Exception("Error al crear una nova Partida");
		}
	}

	public static List<Partida> getPartides(String nom) throws Exception {
		ConnectionBBDD connection = LoginBBDD.getConnection();

		try {

			String sql = "SELECT * FROM PARTIDA WHERE NOM = ?";

			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.clearParameters();
			preparedStatment.setString(1, nom);
			ResultSet rs = preparedStatment.executeQuery();

			List<Partida> partidesJugador = new ArrayList<Partida>();
			
			while (rs.next()) {
				int d1, d2;

				d1 = rs.getInt("DAU1");
				d2 = rs.getInt("DAU2");
				partidesJugador.add(new Partida(d1, d2));
			}
			
			return partidesJugador;

		} catch (SQLException e) {
			throw new Exception("Error al buscar les partides", e);
		}

	}

}
