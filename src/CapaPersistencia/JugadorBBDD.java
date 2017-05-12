package CapaPersistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CapaDomini.Jugador;
import CapaDomini.Partida;


public class JugadorBBDD {

		public static boolean existJugador(String nom) throws Exception {
			ConnectionBBDD connection = LoginBBDD.getConnection();

			try {

				String sql = "SELECT * FROM JUGADOR WHERE NOM = ?";

				PreparedStatement preparedStatment = connection.prepareStatement(sql);
				preparedStatment.clearParameters();
				preparedStatment.setString(1, nom);
				ResultSet rs = preparedStatment.executeQuery();

				return rs.next();
				
			} catch (SQLException e) {
				throw new Exception("Error al agafar la moneda", e);
			}

		}

		public void storePartida(Partida partida, int idPartida) throws Exception {

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

	
	///
	

}