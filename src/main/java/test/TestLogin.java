
package test;

import crow.asmaven.dao.UsuarioFacade;
import crow.asmaven.dto.Platillo;
import crow.asmaven.dto.Usuario;
import crow.asmaven.ws.WebServiceDomino;
import crow.asmaven.ws.WebServiceEmpresa;


public class TestLogin {

   
    public static void main(String[] args) {
        
        WebServiceEmpresa wse = new WebServiceEmpresa();
        wse.ValidarConvenio(20689547);
        
        WebServiceDomino wsd = new WebServiceDomino();
        for (Platillo item : wsd.Platillos()) {
            System.out.println(item.getPlatilloId());
            System.out.println(item.getValor());
            System.out.println(item.getPromedioPreparacion());
            System.out.println(item.getDescripcion());
            System.out.println(item.getSrc());
            System.out.println(item.getNombre());
            System.out.println("-----------------------------------------");
        }
        
    }
    
}
