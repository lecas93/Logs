package controladorBitacora;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloBitacora.Registro;

/**
 *
 * @author Samuel Aké
 */
public class BitacoraEspacialDeBuzzLightYear {

    private void escribirRegistro(String cadenaRegistro, String nivelBitacora) {

        Gson gson = new Gson();
        InformacionMaquina informacionMaquina = new InformacionMaquina();
        Date fechaRegistro = new Date();
        Registro nuevoRegistro = new Registro(nivelBitacora, cadenaRegistro, fechaRegistro.toString(),
                 "Version 1.0", informacionMaquina.obtenerInformacionSO(), informacionMaquina.obtenerInformacionEquipo());

        String jsonString = gson.toJson(nuevoRegistro);
        
        try {
            leerRegistros();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BitacoraEspacialDeBuzzLightYear.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void leerRegistros() throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        FileReader fr = new FileReader("datos.json");
        JsonElement datos = parser.parse(fr);
        parseJSon(datos);
        
    }

    private void parseJSon(JsonElement elementosJSon) {    
            System.out.println("parsejson");
            System.out.println(elementosJSon.getAsJsonObject().get("Nivel"));
    }

    private void writeJSonFile(String datos) {
 PrintWriter writer = null;
        try {
            File json = new File("datos.json");
            writer = new PrintWriter("datos.json", "UTF-8");
            writer.println(datos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BitacoraEspacialDeBuzzLightYear.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BitacoraEspacialDeBuzzLightYear.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }

    public void fatal(Exception tipoFatal) {
        escribirRegistro(tipoFatal.toString(), "Fatal");
    }

    public void error(Exception tipoError) {

    }

    public void warn(Exception tipoWarn) {

    }

    public void info(Exception tipoInfo) {

    }

    public void trace(Exception tipoTrace) {

    }
}
