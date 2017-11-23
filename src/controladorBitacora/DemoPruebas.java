/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorBitacora;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author neko__000
 */
public class DemoPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        InformacionMaquina info = new InformacionMaquina();
//        System.out.println(info.obtenerInformacionMaquina());
        
//        ConfigurarBitacora confi = new ConfigurarBitacora();
//        try {
//            System.out.println(confi.obtenerConfiguracionXML("Tamanio"));
//        } catch (ParserConfigurationException ex) {
//            Logger.getLogger(DemoPruebas.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SAXException ex) {
//            Logger.getLogger(DemoPruebas.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(DemoPruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        

// git test v1
        
        BitacoraEspacialDeBuzzLightYear nuevaB = new BitacoraEspacialDeBuzzLightYear();
        int valor = 1,valor2 = 0;
        try {
            double valor3 = valor / valor2;
        } catch (Exception e){
            nuevaB.fatal(e);
        }
        
        
    }
    
}
