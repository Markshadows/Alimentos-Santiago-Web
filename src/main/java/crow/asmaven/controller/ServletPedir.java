/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.controller;

import crow.asmaven.dao.PedidoFacade;
import crow.asmaven.dao.PlatilloFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duoc
 */
public class ServletPedir extends HttpServlet {

    //estado ya no va por que por defecto es preparando
    //@EJB
    //private EstadoPedidoFacade estadoPedidoFacade;
    //lista de combo box

    //Lista de Platillos
    @EJB
    private PlatilloFacade platilloFacade;

    //Pedido FINAL
    @EJB
    private PedidoFacade pedidoFacade;

    //@EJB
    //private ClienteFacade clienteFacade;
    private String mensaje = null;
    private String paginaRetorno = "panel-cliente.jsp";
    private Object objeto = null;
    private final String pag_error = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("btnAccion");

        if (opcion.equals("Pedir")) {
            AgregarPedido(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void AgregarPedido(HttpServletRequest request, HttpServletResponse response) {

        try {
            //int idFormaPago = Integer.parseInt(request.getParameter("txtIdCliente"));
            int idFormaPago = 1;
            String direccion = request.getParameter("txtDireccion");
            int idPlatillo = Integer.parseInt(request.getParameter("txtIdPlatillo"));
            int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));

            //pedidoFacade.HacerPedido(idFormaPago, direccion, idPlatillo, idCliente);
            //pedidoFacade.HacerPedido(idFormaPago, direccion, idPlatillo, idCliente);
            response.sendRedirect(paginaRetorno);
            
        } catch (Exception e) {
            System.out.println("errorror agregar pedido");
            
        }

    }

}
