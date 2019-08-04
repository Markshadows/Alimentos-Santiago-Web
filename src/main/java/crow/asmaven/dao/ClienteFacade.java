/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dao;

import crow.asmaven.dto.Cliente;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author M_arc
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "crow_ASMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public int IniciarSesion(String nombre, String contrasena) {
        try {
            BigDecimal res = (BigDecimal) em.createNativeQuery(
                    "SELECT fn_login_cliente(?, ?) FROM DUAL")
                    .setParameter(1, nombre)
                    .setParameter(2, contrasena)
                    .getSingleResult();
            System.out.println(res);
            return res.intValueExact();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    
     public Object listaDatosCLientes() {
        
        Query query = em.createQuery(
                "SELECT cli.nombre, tus.usuario.nombre,cli.rut FROM Cliente cli"
                        + " JOIN cli.usuarioTipoUsuario tus where cli.nombre = 'Carlos'");
        return query.getSingleResult();
    }
    
    
}
