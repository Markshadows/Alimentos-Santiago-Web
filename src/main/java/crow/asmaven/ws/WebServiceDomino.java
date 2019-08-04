/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.ws;

import crow.asmaven.dto.Platillo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author M_arc
 */
public class WebServiceDomino {
    final String GlobalUrl = "http://localhost:64734/domino/api";

    public List<Platillo> Platillos() {
        try {
            List<Platillo> platillos = new ArrayList<>();
            //Creamos una variable URL en donde le pasamos la ruta para acceder al WS.
            URL url = new URL(GlobalUrl + "/platillos");
            //Creamos la variable conn y abrimos la conexion.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Indicamos que la llamada la realizaremos a traves de un metodo GET
            conn.setRequestMethod("GET");
            //indicamos que la respuesta se recibirá a traves de JSON
            conn.setRequestProperty("Accept", "application/json");
            //Preguntamos si la respueata de la solicitud es distinto de 200
            //HTTP 200 OK indica que la solicitud ha tenido éxito.
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            //InputStreamReader lee la respuesta como una serie de bytes.
            InputStreamReader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
            //Transformamos esa respuesta en un string con el BufferedReader
            BufferedReader br = new BufferedReader(in);
            String output;
            String jsonRespuesta = "";
            //Recorremos la respuesta y la almacenamos en la variable jsonRespuesta
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                jsonRespuesta = output;
            }
            //Transformamos la repsuesta en un array JSON
            JSONArray json = new JSONArray(jsonRespuesta);
            //Recorremos el arreglo, lo almacenamos en el objeto (JSONObject e) y finalemnte imprimimos las variables
            for (int i = 0; i < json.length(); i++) {

                final JSONObject e = json.getJSONObject(i);
                platillos.add(
                        new Platillo() {
                    {
                        setPlatilloId((short) e.getInt("Id"));
                        setValor(e.getInt("Valor"));
                        setPromedioPreparacion((short) e.getInt("PromedioPreparacion"));
                        setDescripcion(e.getString("Descripcion"));
                        setSrc(e.getString("Src"));
                        setNombre(e.getString("Nombre"));
                    }
                }
                );
//                System.out.println("ID: "+e.getInt("Id"));
//                System.out.println("Nombre: "+e.getString("Nombre"));
//                System.out.println("Autor: "+e.getString("Fecha"));
//                System.out.println("Stock: "+e.getString("Descripcion"));
//                System.out.println("Stock: "+e.getString("Lugar"));
//                System.out.println("***************************************");

            }

            //Cerramos la conexion.
            conn.disconnect();
            return platillos;

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return null;
        }
    }
}
