/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dao;

import crow.asmaven.dto.Dia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author M_arc
 */
@Stateless
public class DiaFacade extends AbstractFacade<Dia> {

    @PersistenceContext(unitName = "crow_ASMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiaFacade() {
        super(Dia.class);
    }
    
}
