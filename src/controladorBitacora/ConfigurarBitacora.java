/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorBitacora;

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
 *
 * @author Samuel Aké
 */
public class ConfigurarBitacora {
    
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
