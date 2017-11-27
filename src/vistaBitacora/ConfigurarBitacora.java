/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaBitacora;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 * Clase que se encargar de configurar la bitacora con el formato XML proporcionado por el usuario en el archivo de configuración.
 * @author Samuel Aké y Andrés Castellanos
 */
public class ConfigurarBitacora {
    /**
     * 
     * @param elementoAConfigurar El elemento en particular del archivo de configuración que se modificará.
     * @param nuevoValor El valor que obtendrá el elemento a configurar.
     * @throws ParserConfigurationException 
     * @throws SAXException
     * @throws IOException Excepción en caso de que no se encuentre el archivo.
     */
    public void configurarBitacoraXML(String elementoAConfigurar, String nuevoValor) throws ParserConfigurationException, SAXException, IOException{
        File inputFile = new File("Recursos/ArchivoConfiguracion.txt");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Bitacora");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        eElement.getElementsByTagName(elementoAConfigurar).item(0).setTextContent(nuevoValor);
    }
    
    /**
     *
     * @param elementoAObtener
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public String obtenerConfiguracionXML(String elementoAObtener) throws ParserConfigurationException, SAXException, IOException{
        File inputFile = new File("Recursos/ArchivoConfiguracion.txt");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Bitacora");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        return eElement.getElementsByTagName(elementoAObtener).item(0).getTextContent();
    }
    
}
