package crow.asmaven.controller;

import crow.asmaven.dao.ClienteFacade;
import crow.asmaven.dao.TipoUsuarioFacade;
import crow.asmaven.dao.UsuarioFacade;
import crow.asmaven.dao.UsuarioTipoUsuarioFacade;
import crow.asmaven.dto.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletRegistroUsuario extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;

    
    
    private String mensaje = null;
    private String paginaRetorno = null;
    private Object objeto = null;
    private final String pag_error = "error.jsp";
    private final String pag_inicio = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opcion = request.getParameter("btnAccion");

        if (opcion.equals("registrar")) {
            RegistrarUsuario(request, response);
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

    private void RegistrarUsuario(HttpServletRequest request, HttpServletResponse response) {

        try {
            //Usuario
            String username = request.getParameter("txtNombreUsuario");
            String pass = request.getParameter("txtContrasenia");

            //CLiente
            String pNombre = request.getParameter("txtPrimerNombre");

            String apellidoP = request.getParameter("txtApellidoPaterno");
            String apellidoM = request.getParameter("txtApellidoMaterno");
            String rutSinConvertir = request.getParameter("txtRut");
            String[]partesRut = rutSinConvertir.split("-");
            int rutConvertido = Integer.parseInt(partesRut[0]);
            char dv = partesRut[1].charAt(0);

            
            //System.out.println(username+'\n'+pass+'\n'+pNombre+'\n'+apellidoP+'\n'+apellidoM+'\n'+rutConvertido
            //+'\n'+dv);

            int resultado = usuarioFacade.CrearCuenta(username, pass, 5, pNombre, apellidoP, apellidoM, rutConvertido);

            switch(resultado){
                case 1:
                    mensaje = "Cuenta Creada";
                    break;
                case 2:
                    mensaje = "Ya existe una cuenta con ese rut";
                    break;
                case 3:
                    mensaje = "Nombre de usuario en uso";
                    break;
                default:
                        mensaje = "error al crear cuenta";
            }
            request.getSession().setAttribute("mensaje", mensaje);
            response.sendRedirect("registro-cliente.jsp");
        } catch (Exception e) {
            System.out.println("error Servlet RegistrarUsuario   " + e.getMessage());
        }

    }

}
