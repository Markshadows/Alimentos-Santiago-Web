/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author M_arc
 */
public class WebServiceEmpresa {

    static String GlobalUrl = "http://localhost:54659/api/negocio";

//    public boolean ValidarConvenio(int rutEmpleado) {
//        boolean respuesta = false;
//        try {
//            //Creamos una variable URL en donde le pasamos la ruta para acceder al WS.
//            URL url = new URL(GlobalUrl + "/ValidarEmpleado/" + rutEmpleado);
//            //Creamos la variable conn y abrimos la conexion.
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            //Indicamos que la llamada la realizaremos a traves de un metodo GET
//            conn.setRequestMethod("GET");
//            //indicamos que la respuesta se recibirá a traves de JSON
//            conn.setRequestProperty("Accept", "application/json");
//            //Preguntamos si la respueata de la solicitud es distinto de 200
//            //HTTP 200 OK indica que la solicitud ha tenido éxito.
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP Error code : "
//                        + conn.getResponseCode());
//            }
//            //InputStreamReader lee la respuesta como una serie de bytes.
//            InputStreamReader in = new InputStreamReader(conn.getInputStream());
//            //Transformamos esa respuesta en un string con el BufferedReader
//            BufferedReader br = new BufferedReader(in);
//            String output;
//            //Recorremos la respuesta y la almacenamos en la variable jsonRespuesta
//            while ((output = br.readLine()) != null) {
//                //System.out.println(output);
//                respuesta = Boolean.parseBoolean(output);
//            }
//            //Cerramos la conexion.
//            conn.disconnect();
//            return respuesta;
//
//        } catch (Exception e) {
//            System.out.println("Exception in NetClientGet:- " + e);
//            return respuesta;
//        }
//    }
    public ObjetoValidarConvenio ValidarConvenio(int rutEmpleado) {
        try {

            ObjetoValidarConvenio objeto = null;
            //Creamos una variable URL en donde le pasamos la ruta para acceder al WS.
            URL url = new URL(GlobalUrl + "/ValidarEmpleado/" + rutEmpleado);
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
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
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
            JSONObject e = new JSONObject(jsonRespuesta);
            //Recorremos el arreglo, lo almacenamos en el objeto (JSONObject e) y finalemnte imprimimos las variables


                objeto = new ObjetoValidarConvenio(
                        e.getInt("ConvenioId"),
                        e.getInt("Saldo"),
                        e.getInt("Vigente"),
                        e.getInt("Empleado"));

            //Cerramos la conexion.
            conn.disconnect();
            return objeto;

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return null;
        }
    }

    public int TransaccionRealizada(int rut, int monto) {
        try {
            //Creamos una variable URL en donde le pasamos la ruta para acceder al WS.
            URL url = new URL(GlobalUrl + "/TransaccionRealizada/" + rut + "/" + monto);
            //Creamos la variable httpCon y abrimos la conexion.
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            //Indicamos que esperamos recibir un output por parte de la conexion. Por defecto es false.
            httpCon.setDoOutput(true);
            //Indicamos el metodo por el cual accederemos a la solicitud.
            httpCon.setRequestMethod("POST");
            //Creamos la variable out a traves de la cual hacemos el llamado a nuestro WS con la funcion getOutputStream().
            OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
            //Cerramos la conexion de escritura.
            out.close();
            //Obtenemos la respuesta de la ejecucion de nuestro llamado al ws en bytes y la trasnformamos a string.
            BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            int respuesta = Integer.parseInt(br.readLine());

            return respuesta;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return 0;
        }
    }
}
