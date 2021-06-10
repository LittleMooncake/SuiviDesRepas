package fr.eni.dal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/modules/module4/ServletTestPoolConnexion")
public class Settings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Context context = new InitialContext();
			//Recherche de la DataSource (le pool de connexion)
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/cnxSuiviRepas");
			/*
			 * Demande une connexion. La méthode getConnection met la demande
			 * en attente tant qu'il n'y a pas de connexion disponible dans le pool.
			 */
			Connection cnx = dataSource.getConnection();
			response.getWriter().append("La connexion est " + (cnx.isClosed() ? "fermée" : "ouverte"));
			//on libère la connexion --> elle est remise dans le pool
			cnx.close();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Erreur lors de la connexion à la BDD");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //code erreur 500
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
