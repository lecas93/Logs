package controladorBitacora;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
        JsonParser parser = new JsonParser();

        escribirArchivoJson(parser.parse(jsonString));
    }

    private JsonArray leerRegistros() {
        FileReader fr = null;
        try {
            JsonParser parser = new JsonParser();
            fr = new FileReader("datos.json");
            JsonArray datos = parser.parse(fr).getAsJsonArray();
            return datos;
        } catch (FileNotFoundException ex) {
            try {
                crearJson();
                return new JsonArray();
            } catch (IOException ex1) {
                Logger.getLogger(BitacoraEspacialDeBuzzLightYear.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IllegalStateException ise) {
            return new JsonArray();
        } 
        return null;
    }

    private void parseJSon(JsonElement elementosJSon) {
        System.out.println("parsejson");
        System.out.println(elementosJSon.getAsJsonObject().get("Nivel"));
    }

    private void escribirArchivoJson(JsonElement json) {
        File archivo = null;
        FileWriter fr = null;
        BufferedWriter br = null;

        try {

            JsonArray registros = leerRegistros();
            registros.add(json);
            System.out.println(registros.toString());
            archivo = new File("datos.json");
            fr = new FileWriter(archivo);
            br = new BufferedWriter(fr);
            br.write(registros.toString());

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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

    private void crearJson() throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(new File("datos.json"), true));  //clears file every time

    }
}
