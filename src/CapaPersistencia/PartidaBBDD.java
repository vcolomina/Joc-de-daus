package CapaPersistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CapaDomini.Jugador;
import CapaDomini.Partida;

public class PartidaBBDD {


	//	private static Partida partida;

	public void createPartida(Jugador jugador, Partida partida, int idPartida) throws Exception {

		ConnectionBBDD connection = LoginBBDD.getConnection();
		
		try {

			String sql = "INSERT INTO PARTIDA VALUES(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, jugador.getNom());
			pst.setInt(2, partida.getDau1());
			pst.setInt(3, partida.getDau2());
			pst.setInt(4, idPartida);

			
			
		} catch (SQLException e) {
			throw new Exception("Error al crear una nova Partida");
		}
	}

	
	
	public static Partida getPartida(int idPartida) throws Exception {
		ConnectionBBDD connection = LoginBBDD.getConnection();

		try {

			String sql = "SELECT * FROM PARTIDA WHERE IDPARTIDA = ?";

			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.clearParameters();
			preparedStatment.setInt(1, idPartida);
			ResultSet rs = preparedStatment.executeQuery();

			while (rs.next()) {
				int d1, d2;

				d1 = rs.getInt("DAU1");
				d2 = rs.getInt("DAU2");
				return new Partida(d1, d2);
			}

			throw new Exception("No sha trobat la moneda");
		} catch (SQLException e) {
			throw new Exception("Error al agafar la moneda", e);
		}

	}

	public void savePartida(Partida partida, int idPartida) throws Exception {

		ConnectionBBDD connection = LoginBBDD.getConnection();
		
		try {

			String sql = "UPDATE PARTIDA SET DAU1 = ? WHERE ID_PARTIDA = ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, partida.getDau1());
			pst.setInt(2, idPartida);

			if (pst.executeUpdate() != 1) {
				throw new Exception("Partida no guardada");
			}

			sql = "UPDATE PARTIDA SET DAU2 = ? WHERE ID_PARTIDA = ?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, partida.getDau2());
			pst.setInt(2, idPartida);

			if (pst.executeUpdate() != 1) {
				throw new Exception("Partida no guardada");
			}
			
		} catch (SQLException e) {
			throw new Exception("Error al inserir la Partida");
		}
	}

}
