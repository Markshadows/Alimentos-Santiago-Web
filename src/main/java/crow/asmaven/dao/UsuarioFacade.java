/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dao;

import crow.asmaven.dto.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author M_arc
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "crow_ASMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public int IniciarSesion(String nombre, String contrasena) {
        try {
            BigDecimal res = (BigDecimal) em.createNativeQuery(
                    "SELECT fn_login(?, ?) FROM DUAL")
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

    public int CrearCuenta(String nombreUsuario, String contrasena, int tipoUsuario,
            String nombre, String appaterno, String apmaterno, int rut) {
        try {
            StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("PROCEDURE_CREAR_CUENTA");
            query.setParameter("p_nombre_usuario", nombreUsuario);
            query.setParameter("p_contrasena", contrasena);
            query.setParameter("p_tipo_usuario", tipoUsuario);
            query.setParameter("P_NOMBRE", nombre);
            query.setParameter("P_APPATERNO", appaterno);
            query.setParameter("P_APMATERNO", apmaterno);
            query.setParameter("P_RUT", rut);

            query.execute();
            return (int) query.getOutputParameterValue(8);

        } catch (Exception e) {
            System.out.println("errroorrrrr  en usuario facade   " + e.getMessage());
            return 0;

        }
    }

}
