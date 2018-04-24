
package Servlets;

import Modelos.Mesa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rian Alves
 */
@WebServlet(name = "MesaServlet", urlPatterns = {"/index.html"})
public class MesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("/index.html".equals(request.getServletPath()))
        {   //anexo para a requisição 
            request.setAttribute("mesas", Mesa.inicializaMesas());
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/mesas.jsp");
            despachante.forward(request, response);
        
        }
    }
  
   
}
