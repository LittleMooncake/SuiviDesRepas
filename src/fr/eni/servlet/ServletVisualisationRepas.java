package fr.eni.servlet;

import fr.eni.BusinessException;
import fr.eni.bll.RepasManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/ServletVisualisationRepas")
public class ServletVisualisationRepas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Historique.jsp");
        try {
            request.setAttribute("historique", RepasManager.selectAll());
        } catch (BusinessException e) {
            request.setAttribute("listeCodeErreur", e.getListeCodeErreur());
        }
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
