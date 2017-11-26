
package controladorBitacora;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import modeloBitacora.EstructuraMensaje;
import modeloBitacora.Registro;

/**
 *
 * @author Samuel Aké
 */
public class BitacoraEspacialDeBuzzLightYear {
    private String rutaNuevoArchivoRegistro;
    private String rutaArchivoRegistro;
    
    private String escribirRegistro(String cadenaRegistro, String nivelBitacora) {

        Gson gson = new Gson();
        InformacionMaquina informacionMaquina = new InformacionMaquina();
        Date fechaRegistro = new Date();
        Registro nuevoRegistro = new Registro(nivelBitacora, cadenaRegistro, fechaRegistro.toString(),
                "Version 1.0", informacionMaquina.obtenerInformacionSO(), informacionMaquina.obtenerInformacionEquipo());
        nuevoRegistro.setDatoAdicional(obtenerConfiguracionXML("ContenidoExtra"));
        String jsonString = gson.toJson(nuevoRegistro);
        JsonParser parser = new JsonParser();

        return generarDescripcionJson(parser.parse(jsonString));
    }

    private JsonArray leerRegistros() {
        try {
            
            if (isFicheroTamanioAdecuado(getRutaArchivoRegistro())){
                JsonParser parser = new JsonParser();
                FileReader f = new FileReader(getRutaArchivoRegistro());
                BufferedReader b = new BufferedReader(f);
                String descripcionJson = b.readLine();
                if (descripcionJson.compareTo("") != 0){
                    JsonArray datos = parser.parse(descripcionJson).getAsJsonArray();
                    return datos;
                }   else    {
                    return new JsonArray();
                }
            }   else    {
                return new JsonArray();
            }
            
        } catch (Exception ex) {
            System.out.println("Error en los Registros");
        }
        return null;
    }

    private String generarDescripcionJson(JsonElement json) {
        JsonArray registros = leerRegistros();
        registros.add(json);
        return registros.toString();
    }
 
    
    public void fatal (Exception tipoFatal){
        registroGeneral(tipoFatal,"Fatal");
        
    }
    
    public void error (Exception tipoError){
        registroGeneral(tipoError, "Error");
    }
    
    public void warn (Exception tipoWarn){
        registroGeneral(tipoWarn,"Warn");
    }
    
    public void info (Exception tipoInfo){
        registroGeneral(tipoInfo, "Info");
    }
    
    public void trace (Exception tipoTrace){
        registroGeneral(tipoTrace, "Trace");
    }
    
    private void registroGeneral(Exception tipoGeneral, String tipoRegistro){
        String cuerpoRegistro = "";
        Date fechaRegistro = new Date();
        String fechaRegistroCadena = fechaRegistro.getDate() + "-" + fechaRegistro.getMonth() 
                + "-" + fechaRegistro.getYear();
        
        if (isNivelSuficiente(tipoRegistro)){
            obtenerRutaFichero(fechaRegistroCadena);
            cuerpoRegistro = escribirRegistro(tipoGeneral.toString(), tipoRegistro);
            enviarRegistroPorCorreo(tipoRegistro, cuerpoRegistro);
            registrarNuevoRegistro(cuerpoRegistro);
            
        }
        
    }
    
    public void configurarBitacoraEspacial(String elementoAConfigurar, String nuevoValor){
        try {
            new ConfigurarBitacora().configurarBitacoraXML(elementoAConfigurar, nuevoValor);
        } catch (Exception ex) {
            fatal(ex);
        }
    }
    
    private String obtenerConfiguracionXML(String elementoAObtener){
        try {
            return new ConfigurarBitacora().obtenerConfiguracionXML(elementoAObtener);
        } catch (Exception ex) {
            error(ex);
            return "";
        } 
    }
    
    private void enviarRegistroPorCorreo(String tituloMensaje, String registroJSON){
        Date fechaRegistro =new  Date();
        if (obtenerConfiguracionXML("ModoCorreo").contains("True")){
            new EstructuraMensaje().sendEmail(fechaRegistro + " - " + tituloMensaje, registroJSON);
        }
    }
    
    private void obtenerRutaFichero(String fechaRegistro){
        String rutaCarpetaContenedora = obtenerConfiguracionXML("DireccionGuardado");
        int indiceRegistro = 0;
        String rutaNuevoArchivoRegistro = "";
        File carpetaRegistros = new File(rutaCarpetaContenedora + "/Registros Bitacora");
        if (!carpetaRegistros.exists()) {
            carpetaRegistros.mkdir();
        }
        
        File carpetaRegistroPorDia = new File(rutaCarpetaContenedora + "/Registros Bitacora/" + fechaRegistro);
        if (!carpetaRegistroPorDia.exists()){
            carpetaRegistroPorDia.mkdir();
        }
        File archivoRegistroPorDia;
        
        do {
            indiceRegistro++;
            rutaNuevoArchivoRegistro = rutaCarpetaContenedora + "/Registros Bitacora/" 
                    + fechaRegistro + "/" + indiceRegistro + ".json";
             archivoRegistroPorDia = new File(rutaNuevoArchivoRegistro);
        } while (archivoRegistroPorDia.exists());
        
        setRutaNuevoArchivoRegistro(rutaCarpetaContenedora + "/Registros Bitacora/" 
                    + fechaRegistro + "/" + indiceRegistro + ".json");
        indiceRegistro--;
        setRutaArchivoRegistro(rutaCarpetaContenedora + "/Registros Bitacora/" 
                    + fechaRegistro + "/" + indiceRegistro + ".json");
        if (!new File(getRutaArchivoRegistro()).exists()){
            escribirJSON(getRutaArchivoRegistro(), "");
        }
    }
    
    private void registrarNuevoRegistro(String descripcionRegistro){
        if (isFicheroTamanioAdecuado(getRutaArchivoRegistro())){
            escribirJSON(getRutaArchivoRegistro(), descripcionRegistro);
        }   else    {
            escribirJSON(getRutaNuevoArchivoRegistro(), descripcionRegistro);
        }
    }

    
    
    private boolean isNivelSuficiente(String nivelRegistro){
        String nivelConfigurado = obtenerConfiguracionXML("Nivel");
        String arregloNiveles;
        switch(nivelConfigurado){
            case "Fatal":
                if (nivelRegistro.compareTo("Fatal") == 0){
                    return true;
                }   else    {
                    return false;
                }
            case "Error":
                arregloNiveles = "Fatal Error";
                if (arregloNiveles.contains(nivelRegistro)){
                    return true;
                }   else    {
                    return false;
                }
            case "Warn":
                arregloNiveles = "Fatal Error Warn";
                if (arregloNiveles.contains(nivelRegistro)){
                    return true;
                }   else    {
                    return false;
                }
            case "Info":
                arregloNiveles = "Fatal Error Warn Info";
                if (arregloNiveles.contains(nivelRegistro)){
                    return true;
                }   else    {
                    return false;
                }
            case "Trace":
                arregloNiveles = "Fatal Error Warn Info Trace";
                if (arregloNiveles.contains(nivelRegistro)){
                    return true;
                }   else    {
                    return false;
                }
        }
        return false;
    }
    
    private void escribirJSON(String rutaRegistro, String descripcionRegistro) {
       PrintWriter fileOut;
       
        try {
            fileOut = new PrintWriter(new FileWriter (rutaRegistro, false));
            fileOut.println(descripcionRegistro);
            
            fileOut.close();
        } catch (Exception ex) {
            warn(ex);
        }
    }
    
    
    private boolean isFicheroTamanioAdecuado(String rutaFichero){
        long tamanioFichero = 0;
        long tamanioFicheroConfiguracion = 0;
        try {
            File fichero = new File(rutaFichero);
            tamanioFichero = fichero.length();
        } catch (Exception ex){
            warn(ex);
        }
        
        tamanioFicheroConfiguracion = Long.parseLong(obtenerConfiguracionXML("Tamanio"));
        return tamanioFichero < tamanioFicheroConfiguracion;
    }

    private String getRutaNuevoArchivoRegistro() {
        return rutaNuevoArchivoRegistro;
    }

    private void setRutaNuevoArchivoRegistro(String rutaNuevoArchivoRegistro) {
        this.rutaNuevoArchivoRegistro = rutaNuevoArchivoRegistro;
    }

    private String getRutaArchivoRegistro() {
        return rutaArchivoRegistro;
    }

    private void setRutaArchivoRegistro(String rutaArchivoRegistro) {
        this.rutaArchivoRegistro = rutaArchivoRegistro;
    }
    
    
}
