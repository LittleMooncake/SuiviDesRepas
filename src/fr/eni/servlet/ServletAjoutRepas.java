package fr.eni.servlet;

import fr.eni.bll.RepasManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

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
        RepasManager.inserRepas(LocalDate.parse(request.getParameter("date")),
                LocalTime.parse(request.getParameter("time")),
                request.getParameter("aliments"));
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Historique.jsp");
        request.setAttribute("historique", RepasManager.selectAll());
        rd.forward(request, response);
    }
}
