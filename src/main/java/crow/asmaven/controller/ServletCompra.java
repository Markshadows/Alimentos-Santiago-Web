package crow.asmaven.controller;

import crow.asmaven.dao.CuentaFacade;
import crow.asmaven.dao.DetalleVentaFacade;
import crow.asmaven.dao.FormaPagoFacade;
import crow.asmaven.dao.PedidoFacade;
import crow.asmaven.dao.PlatilloFacade;
import crow.asmaven.dao.VentaFacade;
import crow.asmaven.dto.Cliente;
import crow.asmaven.dto.Cuenta;
import crow.asmaven.dto.DetalleVenta;
import crow.asmaven.dto.Pedido;
import crow.asmaven.dto.Platillo;
import crow.asmaven.dto.Venta;
import crow.asmaven.ws.ObjetoValidarConvenio;
import crow.asmaven.ws.WebServiceDomino;
import crow.asmaven.ws.WebServiceEmpresa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCompra extends HttpServlet {

    @EJB
    private VentaFacade ventaFacade;

    private String mensajeError = null;
    private String mensajeAviso = null;

    @EJB
    private CuentaFacade cuentaFacade;

    @EJB
    private DetalleVentaFacade detalleVentaFacade;

    static String GlobalUrl = "http://localhost:50368/api/negocio";

    @EJB
    private PedidoFacade pedidoFacade;

    @EJB
    private FormaPagoFacade formaPagoFacade;

    @EJB
    private PlatilloFacade platilloFacade;

    private String mensaje = null;
    private String paginaRetorno = "panel-cliente.jsp";
    private String paginaCliente = "menu-cliente.jsp";
    private Object objeto = null;
    private final String pag_error = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String opcion = request.getParameter("btnAccion");

        opcion = opcion != null ? opcion : "";
        switch (opcion) {
            case "Pedir":
                AgregarPedido(request, response);
                break;
            case "agregarSaldo":
                AgregarSaldo(request, response);
                break;
            case "CambiarHora":
                CambiarHora(request, response);
                break;
            default:
                listar(request, response);
                break;
        }
        MisPedidos(request, response);

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        try {
            WebServiceDomino wsd = new WebServiceDomino();
            
            request.getSession().setAttribute("listaPlatillos", platilloFacade.AlimentosSantaigo());
            request.getSession().setAttribute("listaPlatillosWS", wsd.Platillos());
            request.getSession().setAttribute("listaFormaPago", formaPagoFacade.findAll());
        } catch (Exception e) {
            System.out.println("error listar " + e.getMessage());
        }
    }

    private void AgregarPedido(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //variables de sesión necesarias para el insert
        Cliente cliente = (Cliente) request.getSession().getAttribute("objeto");
        Cuenta cuenta = (Cuenta) request.getSession().getAttribute("cuentaCliente");
        //inputs del formulario cliente-compra
        int idFormaDePago = Integer.parseInt(request.getParameter("cboFormaPago"));
        String direccion = request.getParameter("txtDireccion");
        //lista para almacenar los resultados del procedimiento
        List<Integer> resultados = new ArrayList<>();
        List<Platillo> platillos = new ArrayList<>();
        //lista para almacenar los platillos sin los strings vacios
        List<Integer> cantidadPlatillosEscogidos = new ArrayList<>();
        short idPlatillo = 0;
        Platillo platillo = new Platillo();
        int cantidadPlatillos = 0;
        int montoCompra = 0;
        //array para almacenar todos los valores del elemento idPlatillo y cantidadPlatillos
        String[] idPlatillos = (request.getParameterValues("idPlatillo"));
        String[] cantidadPlatillosInput = (request.getParameterValues("cantidadPlatillos"));
        //foreach para agregar a la lista platillos escogidos la cantidad de platillos sin los nulos
        for (String item : cantidadPlatillosInput) {
            if (item.isEmpty() == false) {
                cantidadPlatillosEscogidos.add(Integer.parseInt(item));
            }
        }
        //a partir de los id de platillos seleccionados en el formulario web,
        //se crean tantas clases platillo como selecciones existan
        for (String item : idPlatillos) {
            platillos.add(platilloFacade.find(Short.parseShort(item)));
        }
        //si se selecciona solo un platillo se ejecuta el siguiente codigo
        if (platillos.size() == 1) {
            platillo = platillos.get(0);
            cantidadPlatillos = cantidadPlatillosEscogidos.get(0);
            System.out.println(platillo.getNombre() + "-" + cantidadPlatillos);
            montoCompra = cantidadPlatillos * platillo.getValor();
        } else {
            for (int i = 0; i < platillos.size(); i++) {
                montoCompra += cantidadPlatillosEscogidos.get(i) * platillos.get(i).getValor();
                System.out.println("Monto Compra: " + montoCompra);
            }
        }

//        if (cantidadPlatillosInput.length == 1) {
//            cantidadPlatillos = Integer.parseInt(cantidadPlatillosInput[0]);
//            System.out.println("cantidadPlatillos: " + cantidadPlatillos);
//        } else {
//            for (String string : cantidadPlatillosInput) {
//                System.out.println("");
//            }
//        }
//        if (platillos.size() == 1) {
//            platillo = (Platillo) platilloFacade.find(idPlatillo);
//        } else {
//            for (Platillo item : platillos) {
//                System.out.println(item.getNombre());
//            }
//        }
//
        if (platillos.size() > 0) {

            int montoActual = cuenta.getSaldo();
            System.out.println("monto compra: " + montoCompra);
            System.out.println("monto actual: " + montoActual);
            if (montoCompra <= montoActual) {

                //CLIENTE CONVENIO
                if (cliente.getUsuarioTipoUsuario().getTipoUsuario().getTipoUsuarioId() == 6) {
                    WebServiceEmpresa wse = new WebServiceEmpresa();
                    ObjetoValidarConvenio respuestaWS = wse.ValidarConvenio(cliente.getRut());
                    if (respuestaWS != null) {

                        resultados = pedidoFacade.HacerPedido(1, 0, 0, idFormaDePago, cantidadPlatillos, direccion, idPlatillo, cliente.getClienteId());

                        DetalleVenta detalleVenta = (DetalleVenta) detalleVentaFacade.find(resultados.get(0));
                        Venta venta = (Venta) ventaFacade.find(resultados.get(0));
                        int respuestaWSTransaccion = wse.TransaccionRealizada(cliente.getRut(), detalleVenta.getTotal().intValue());
                        if (respuestaWSTransaccion == 2) {
                            cuenta.setSaldo(montoActual - detalleVenta.getTotal().intValue());
                            cuentaFacade.edit(cuenta);
                            mensaje = "Pedido Hecho";
                            request.getSession().setAttribute("venta", venta);
                            request.getSession().setAttribute("detalleVenta", detalleVenta);
                        } else {
                            mensaje = "Transacción no realizada";
                        }
                    } else {
                        mensaje = "Cliente con saldo insuficiente o sin convenio vigente";
                    }
                }

                //CLIENTE NORMAL
                if (cliente.getUsuarioTipoUsuario().getTipoUsuario().getTipoUsuarioId() == 5) {

                    if (platillos.size() == 1) {

                        resultados = pedidoFacade.HacerPedido(1, 0, 0, idFormaDePago, cantidadPlatillos,
                                direccion, platillo.getPlatilloId(), cliente.getClienteId());
                    } else {
                        for (int i = 0; i < platillos.size(); i++) {
                            if (i == 0) {
                                resultados = pedidoFacade.HacerPedido(1, 0, 0, idFormaDePago, cantidadPlatillosEscogidos.get(i),
                                        direccion, platillos.get(i).getPlatilloId(), cliente.getClienteId());
//                                  System.out.println("primer platito");
//                                  System.out.println("platillos: "+cantidadPlatillosEscogidos.get(i));
//                                        System.out.println("platillo: "+platillos.get(i).getPlatilloId());
                            } else {
                                pedidoFacade.HacerPedido(2, resultados.get(1), resultados.get(0), idFormaDePago, cantidadPlatillosEscogidos.get(i),
                                        direccion, platillos.get(i).getPlatilloId(), cliente.getClienteId());
//                                        System.out.println("detalle_venta: "+resultados.get(0));
//                                        System.out.println("pedido_id: "+resultados.get(1));
//System.out.println("platito nro: "+i);
//                                        System.out.println("platillos: "+cantidadPlatillosEscogidos.get(i));
//                                        System.out.println("platillo: "+platillos.get(i).getPlatilloId());
                            }

                        }
                    }

                    DetalleVenta detalleVenta = (DetalleVenta) detalleVentaFacade.find(resultados.get(0));
                    Venta venta = (Venta) ventaFacade.find(resultados.get(0));

                    if (detalleVenta != null) {
                        cuenta.setSaldo(montoActual - detalleVenta.getTotal().intValue());
                        cuentaFacade.edit(cuenta);
                        mensajeAviso = "Pedido Hecho";
                        request.getSession().setAttribute("venta", venta);
                        request.getSession().setAttribute("detalleVenta", detalleVenta);
                    } else {
                        mensajeError = "Pedido no hecho";
                    }
                }
            } else {
                mensajeError = "Saldo Insuficiente";
            }

        } else {
            mensajeError = "Seleccione un platillo";
        }

        if (mensajeError == null) {

            request.getSession().setAttribute("mensajeCorrectoCompra", mensajeAviso);

            //response.sendRedirect("menu-cliente.jsp");
            response.sendRedirect("boleta-compra.jsp");
        } else {
            request.getSession().setAttribute("mensajeErrorCompra", mensajeError);
            response.sendRedirect("cliente-compra.jsp");
        }

    }

    private void AgregarSaldo(HttpServletRequest request, HttpServletResponse response) {
        try {
            int monto = Integer.parseInt(request.getParameter("cboMonto"));

            Cuenta cuenta = (Cuenta) request.getSession().getAttribute("cuentaCliente");
            cuenta.setSaldo(monto + cuenta.getSaldo());
            cuentaFacade.edit(cuenta);
            request.getSession().setAttribute("mensajeCorrecto", "Saldo Agregado");
            paginaRetorno = paginaCliente;
            response.sendRedirect(paginaRetorno);
        } catch (Exception e) {
        }
    }

    private void MisPedidos(HttpServletRequest request, HttpServletResponse response) {
        Cliente cliente = (Cliente) request.getSession().getAttribute("objeto");
        request.getSession().setAttribute("listaMisPedidos", pedidoFacade.PedidosCliente(cliente.getClienteId()));
    }

    private void CambiarHora(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fechaRecibida = dt1.parse(request.getParameter("txtHoraCambio"));
        
        Pedido pedidoSeleccionado = (Pedido)pedidoFacade.find(Short.parseShort(request.getParameter("txtPedidoId")));
        
        pedidoSeleccionado.setHoraEntrega(fechaRecibida);
        pedidoFacade.edit(pedidoSeleccionado);
        
        response.sendRedirect("menu-cliente.jsp");
    }

}
