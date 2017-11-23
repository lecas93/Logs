
package controladorBitacora;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import modeloBitacora.Registro;

/**
 *
 * @author Samuel Aké
 */
public class BitacoraEspacialDeBuzzLightYear {
    
    
    private void escribirRegistro(String cadenaRegistro, String nivelBitacora){
        Gson gson = new Gson();
        InformacionMaquina informacionMaquina = new InformacionMaquina();
        Date fechaRegistro = new Date();
        Registro nuevoRegistro = new Registro(nivelBitacora, cadenaRegistro, fechaRegistro.toString() 
                , "Version 1.0", informacionMaquina.obtenerInformacionSO(), informacionMaquina.obtenerInformacionEquipo());
        
        String jsonString = gson.toJson(nuevoRegistro);
        System.out.println("JSON: " + jsonString);
    }
    
    private void leerRegistros() throws FileNotFoundException{
        JsonParser parser = new JsonParser();
        FileReader fr = new FileReader("datos.json");
        JsonElement datos = parser.parse(fr);
        parseJSon(datos);
    }
    
    private void parseJSon(JsonElement elementosJSon){
        
    }
    
    public void fatal (Exception tipoFatal){
        escribirRegistro(tipoFatal.toString(), "Fatal");
    }
    
    public void error (Exception tipoError){
        
    }
    
    public void warn (Exception tipoWarn){
        
    }
    
    public void info (Exception tipoInfo){
        
    }
    
    public void trace (Exception tipoTrace){
        
    }
}
