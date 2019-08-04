/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dao;

import crow.asmaven.dto.PlanillaTrabajadores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author M_arc
 */
@Stateless
public class PlanillaTrabajadoresFacade extends AbstractFacade<PlanillaTrabajadores> {

    @PersistenceContext(unitName = "crow_ASMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanillaTrabajadoresFacade() {
        super(PlanillaTrabajadores.class);
    }
    
    public void HacerPedido(int idConvenio, String ruta) {
        try {
            StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("PROCEDURE_INSERT_PLANILLA");
            query.setParameter("p_convenio_id", idConvenio);
            query.setParameter("p_ruta", ruta);

            query.execute();

        } catch (Exception e) {
            System.out.println("errroorrrrr  en pedido facade   " + e.getMessage());

        }
    }
    
}
