package jcbcPack;

import java.sql.*;

public class jcbcMain {
	
	public static void main(String[] args) throws Exception {
		//Class.forName("com.mysql.jdbc.Driver"); //chargement du Driver
		System.out.println( "Affichage de la table Nations");
		String url = "jdbc:mysql://localhost:3306/UnionEuropeBD?serverTimezone=UTC";

		
		Connection con=DriverManager.getConnection(url,"userTest","userTest");
		
		String select = "SELECT * FROM Nations";
		
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			String message = rs.getString("nom") + ", ";
			message = message + rs.getInt("population") + ".";
			System.out.println( message );
		}
		
		con.close();
		System.out.println( "Opération de lecture terminée");
	}


}

