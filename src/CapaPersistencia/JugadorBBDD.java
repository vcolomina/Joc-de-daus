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
				throw new Exception("Error al buscar un jugador", e);
			}

		}

		public static void saveJugador(String nom) throws Exception {

			ConnectionBBDD connection = LoginBBDD.getConnection();
			
			try {

				String sql = "INSERT INTO JUGADOR VALUES(?)";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setString(1, nom);

				if (pst.executeUpdate() != 1) {
					throw new Exception("Jugador no guardat");
				}

			} catch (SQLException e) {
				throw new Exception("Error al guardar un jugador");
			}
			
		}

	
}