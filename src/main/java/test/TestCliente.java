
package test;

import crow.asmaven.dao.ClienteFacade;

/**
 *
 * @author Administrador
 */
public class TestCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ClienteFacade cliente = new ClienteFacade();
        
        //cliente.ClienteUsuario(8);
        System.out.println(cliente.listaDatosCLientes() );
        
    }
    
}
