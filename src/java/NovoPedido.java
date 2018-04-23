/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelos.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/novoPedido.html"})
public class NovoPedido extends HttpServlet {
    
    public Produto item = new Produto(1, "Arroz",13.0);
     public ArrayList<Produto> lstItens = new ArrayList<>();
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lstItens.add(item);
        
        
        
        
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoPedido.jsp");
        request.setAttribute("lstItens", lstItens);
        despachante.forward(request,response);
    }

}
