package Servlets;

import Modelos.ListadeItens;
import Modelos.Mesa;
import Modelos.Pedido;
import Modelos.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
@WebServlet(name = "PedidoServlet", urlPatterns = {"/pedidos.html", "/fechar-pedido.html"})
public class PedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ("/pedidos.html".equals(request.getServletPath())) {
            if ("editar".equals(request.getParameter("operacao"))) {
                Integer idMesa = Integer.parseInt(request.getParameter("mesa"));
                Mesa mesa = Mesa.inicializaMesas().get(idMesa);
                if (mesa.getPedido() == null) {
                    mesa.setPedido(new Pedido(LocalDateTime.now(), null, idMesa));
                }
                request.setAttribute("pedido", mesa.getPedido());
                request.setAttribute("idMesa", mesa.getId());
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedido-alterar.jsp");
                despachante.forward(request, response);

            } else if ("visao".equals(request.getParameter("operacao"))) {
                Integer idMesa = Integer.parseInt(request.getParameter("mesa"));
                Mesa mesa = Mesa.inicializaMesas().get(idMesa);
                if (mesa.getPedido() == null) {
                    mesa.setPedido(new Pedido(LocalDateTime.now(), null, idMesa));
                }
                request.setAttribute("pedido", mesa.getPedido());
                request.setAttribute("idMesa", mesa.getId());
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedido-visualizar.jsp");
                despachante.forward(request, response);

            }
        } else if ("/fechar-pedido.html".equals(request.getServletPath())) {
            Integer idMesa = Integer.parseInt(request.getParameter("mesa"));
            Mesa mesa = Mesa.inicializaMesas().get(idMesa);
            mesa.getPedido().setHoraFim(LocalDateTime.now());

            request.setAttribute("pedido", mesa.getPedido());
            request.setAttribute("idMesa", mesa.getId());
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedido-visualizar.jsp");
            despachante.forward(request, response);

            mesa.setPedido(null);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idMesa = Integer.parseInt(request.getParameter("idmesa"));
        Mesa mesa = Mesa.inicializaMesas().get(idMesa);

        for (Produto produto : ListadeItens.getItens()) {
            Integer quantidade = Integer.parseInt(request.getParameter(produto.getCodigo().toString()));
            mesa.getPedido().getItens().get(produto.getCodigo()).setQuantidade(quantidade);
        }
        response.sendRedirect("pedidos.html?mesa=" + idMesa + "&operacao=visao");
    }

}
