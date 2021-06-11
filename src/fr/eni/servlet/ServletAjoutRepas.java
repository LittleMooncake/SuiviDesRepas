package fr.eni.servlet;

import fr.eni.BusinessException;
import fr.eni.bll.RepasManager;
import fr.eni.bo.Repas;
import fr.eni.dal.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet(value = "/ServletAjoutRepas")
public class ServletAjoutRepas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Ajout.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            RepasManager.inserRepas(LocalDate.parse(request.getParameter("date")),
                    LocalTime.parse(request.getParameter("time")),
                    request.getParameter("aliments"));
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Historique.jsp");
            request.setAttribute("historique", RepasManager.selectAll());
            rd.forward(request, response);
        } catch (BusinessException e){
            request.setAttribute("listeCodeErreur", e.getListeCodeErreur());
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Ajout.jsp");
            rd.forward(request, response);
        }

    }
}
