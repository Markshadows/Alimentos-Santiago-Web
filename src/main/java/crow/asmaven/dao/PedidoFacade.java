/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dao;

import crow.asmaven.dto.Cliente;
import crow.asmaven.dto.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author M_arc
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "crow_ASMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
    public List<Integer> HacerPedido(int variosPlatos, int pPedidoId, int pDetalleVentaId, 
            int idFormaPago, int cantidadPlatillos, String direccion, int idPlatillo, int idCliente) {
        try {
            StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("PROCEDURE_REALIZAR_PEDIDO");
            query.setParameter("p_varios_platos", variosPlatos);
            query.setParameter("p_pedido_id", pPedidoId);
            query.setParameter("p_detalle_venta_id", pDetalleVentaId);
            query.setParameter("p_forma_pago", idFormaPago);
            query.setParameter("p_cantidad_platillos", cantidadPlatillos);
            query.setParameter("p_pedido_direccion", direccion);
            query.setParameter("p_platillo_id", idPlatillo);
            query.setParameter("p_cliente_id", idCliente);

            query.execute();
            int detalleVentaId = (int) query.getOutputParameterValue(9);
            int pedidoId = (int) query.getOutputParameterValue(10);
            List<Integer>resultados = new ArrayList<Integer>();
            resultados.add(detalleVentaId);
            resultados.add(pedidoId);
            return resultados;

        } catch (Exception e) {
            System.out.println("errroorrrrr  en pedido facade   " + e.getMessage());
            return null;

        }
    }
    
    public List<Pedido> PedidosCliente(Object cliente) {
        try {
            Query query = em.createQuery(
                    "SELECT p FROM Pedido p JOIN p.pedidoPlatilloList pepla JOIN pepla.clientePedidoList cpe JOIN cpe.detalleVentaList dv where cpe.clienteId.clienteId="+cliente);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
