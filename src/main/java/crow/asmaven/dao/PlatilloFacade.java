/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dao;

import crow.asmaven.dto.Platillo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author M_arc
 */
@Stateless
public class PlatilloFacade extends AbstractFacade<Platillo> {

    @PersistenceContext(unitName = "crow_ASMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlatilloFacade() {
        super(Platillo.class);
    }

    public List<Platillo> UltimosPlatillos() {
        try {
            Query query = em.createQuery(
                    "SELECT p FROM Platillo p where p.platilloId < 80").setMaxResults(3);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Platillo> AlimentosSantaigo() {
        try {
            Query query = em.createQuery(
                    "SELECT p FROM Platillo p where  p.platilloId < 80");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
