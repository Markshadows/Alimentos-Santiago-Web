/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.controller;

import crow.asmaven.dao.ClienteFacade;
import crow.asmaven.dao.CuentaFacade;
import crow.asmaven.dao.EmpleadoFacade;
import crow.asmaven.dao.EmpleadorFacade;
import crow.asmaven.dao.PlatilloFacade;
import crow.asmaven.dao.UsuarioFacade;
import crow.asmaven.dto.Cliente;
import crow.asmaven.dto.Cuenta;
import crow.asmaven.dto.Empleado;
import crow.asmaven.dto.Empleador;
import crow.asmaven.ws.ObjetoValidarConvenio;
import crow.asmaven.ws.WebServiceEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUsuario extends HttpServlet {

    @EJB
    private PlatilloFacade platilloFacade;

    @EJB
    private EmpleadorFacade empleadorFacade;

    @EJB
    private CuentaFacade cuentaFacade;

    @EJB
    private UsuarioFacade usuarioFacade;

    @EJB
    private EmpleadoFacade empleadoFacade;

    @EJB
    private ClienteFacade clienteFacade;
    
    
    
   
    
    private String mensajeError;
    private String mensajeAviso;
    private String paginaRetorno = null;
    private Object objeto = null;
    private final String pag_error = "error.jsp";
    private final String pag_rrhh = "rrhh.jsp";
    private final String pag_cliente = "menu-cliente.jsp";
    private final String pag_inicio = "index.jsp";
    private final String pag_login_cliente = "login-cliente.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("btnAccion");

        if (opcion.equals("loginEmpleado")) {
            IniciarSesionEmpleado(request, response);
        }
        if (opcion.equals("loginCliente")) {
            IniciarSesionCliente(request, response);
        }
        if (opcion.equals("loginEmpleador")) {
            IniciarSesionEmpleador(request, response);
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

    private void IniciarSesionEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nombre = request.getParameter("txtNombre");
            String contrasena = request.getParameter("txtContrasena");
            short res = (short) usuarioFacade.IniciarSesion(nombre, contrasena);
            if (res > 0) {
                Empleado empleado = empleadoFacade.find(res);
                short tipo_usuario = empleado.getUsuarioTipoUsuario().getTipoUsuario().getTipoUsuarioId();
                if (tipo_usuario == 1 || tipo_usuario == 2 || tipo_usuario == 4) {
                    mensajeError = "Tu perfil se abre desde la aplicaciòn de escritorio";
                    paginaRetorno = pag_inicio;
                } else {
                 mensajeAviso = "Existe Empleado";
                request.getSession().setAttribute("objeto", empleado);   
                }
            } else {
                mensajeError = "No existe el Empleado";
                paginaRetorno = pag_inicio;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mensajeError == null) {
                request.getSession().setAttribute("mensajeCorrecto", mensajeAviso);
            }else{
                 request.getSession().setAttribute("mensajeError", mensajeError);
            }
            
            response.sendRedirect(paginaRetorno);
        }
    }

    private void IniciarSesionCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nombre = request.getParameter("txtNombre");
            String contrasena = request.getParameter("txtContrasena");
            short res = (short) clienteFacade.IniciarSesion(nombre, contrasena);
            if (res > 0) {
                Cliente cliente = clienteFacade.find(res);
                Cuenta cuentaCliente = cuentaFacade.CuentaCliente(cliente.getClienteId());
                short tipo_usuario = cliente.getUsuarioTipoUsuario().getTipoUsuario().getTipoUsuarioId();
                switch (tipo_usuario) {
                    case 5:
                        paginaRetorno = pag_cliente;
                        mensajeError = null;
                        break;
                    case 6:
                        WebServiceEmpresa wse = new WebServiceEmpresa();
                        ObjetoValidarConvenio objv = wse.ValidarConvenio(cliente.getRut());
                        if (objv != null) {
                            if (objv.getVigente() == 1) {
                                cuentaCliente.setSaldo(objv.getSaldoDisponible());
                                cuentaFacade.edit(cuentaCliente);
                                paginaRetorno = pag_cliente;
                                mensajeAviso = "Inicio Correcto";
                            }else{
                                paginaRetorno = pag_login_cliente;
                            }

                        }else{
                            paginaRetorno = pag_login_cliente;
                            mensajeError = "No existe el rut en la empresa";
                        }

                        break;
                }
                request.getSession().setAttribute("cuentaCliente", cuentaCliente);
                request.getSession().setAttribute("objeto", cliente);
            } else {
                mensajeError = "No existe el Cliente";
                paginaRetorno = pag_login_cliente;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mensajeError == null) {
                request.getSession().setAttribute("mensajeCorrecto", mensajeAviso);
            }else{
                 request.getSession().setAttribute("mensajeError", mensajeError);
            }
            response.sendRedirect(paginaRetorno);
        }
    }

    private void IniciarSesionEmpleador(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String nombre = request.getParameter("txtNombre");
            String contrasena = request.getParameter("txtContrasena");
            short res = (short) empleadorFacade.IniciarSesion(nombre, contrasena);
            if (res > 0) {
                Empleador empleador = empleadorFacade.find(res);
                response.sendRedirect("cargar-archivo.jsp");
            }else{
                mensajeError = "No existe Empleador";
                            response.sendRedirect("login-trabajador.jsp");
            }
            
    }



}
