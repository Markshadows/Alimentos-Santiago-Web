/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dao;

import crow.asmaven.dto.Cuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author M_arc
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {

    @PersistenceContext(unitName = "crow_ASMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }
    
        public Cuenta CuentaCliente(Object clienteId) {
        try {
            Cuenta test;
            Query query = em.createQuery(
                    "SELECT c FROM Cuenta c Where c.cliente.clienteId ="+clienteId);
           if (query.getResultList().isEmpty()) {
            test = null;
        } else {
            test = (Cuenta) query.getSingleResult();
        }
        return test;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
