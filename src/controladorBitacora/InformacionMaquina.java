/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorBitacora;
import java.net.UnknownHostException;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;


/**
 *
 * @author Samuel Aké Tello
 */
public class InformacionMaquina {
    private String versionFrameWork = "1.0";
    private OperatingSystem informacionSO;
    private CpuInfo informacionCPU;
    
    
    public InformacionMaquina(){
        this.informacionSO = OperatingSystem.getInstance();
        Sigar informacionMaquina = new Sigar();
        CpuInfo[] listaInformacionCPU;
        try {
            listaInformacionCPU = informacionMaquina.getCpuInfoList();
            setInformacionCPU(listaInformacionCPU[0]);
        } catch (SigarException ex) {
            // Bandera de Logger;
        }
        
    }
    
    public String obtenerInformacionEquipo(){
        String informacionMaquina = "";
        informacionMaquina = " - INFORMACION MAQUINA: "+ obtenerNombreEquipo() 
                + obtenerDireccionIP();
        return informacionMaquina;
    }
    
    public String obtenerInformacionSO(){
        String informacionSO = "";
        informacionSO = obtenerNombreSO() + obtenerArquitecturaSO() + obtenerVersionSO() 
                + obtenerInformacionCPU();
        return informacionSO;
    }
    
    private String obtenerDireccionIP(){
        try {
            return " - IP = " + java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            return " - IP = 0.0.0.0";
        }
    }
    
    private String obtenerNombreSO(){
        return " Sistema Operativo = " + getInformacionSO().getDescription();
    }
    
    private String obtenerArquitecturaSO(){
        return " - Arquitectura SO = " + getInformacionSO().getArch();
    }
    
    private String obtenerVersionSO(){
        return " - Version SO = " + getInformacionSO().getVersion();
    }
    
    private String obtenerVersionFramework(){
        return "Version BitacoraLog = " + this.versionFrameWork;
    }
    
    private String obtenerNombreEquipo(){
        try {
            return " - Nombre Equipo = " + java.net.InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException ex) {
            return " - Nombre Equipo = SinNombre";
        }
    }
    
    private String obtenerInformacionCPU(){
        String informacionCPU = "";
        informacionCPU = "- INFORMACION CPU: Vendedor : " + getInformacionCPU().getVendor() 
                + " - Modelo : " + getInformacionCPU().getModel() + " - Frecuencia (Mhz): " 
                + getInformacionCPU().getMhz();
        return informacionCPU;
                
    }
    
    public OperatingSystem getInformacionSO() {
        return informacionSO;
    }

    public void setInformacionSO(OperatingSystem informacionSO) {
        this.informacionSO = informacionSO;
    }

    public CpuInfo getInformacionCPU() {
        return informacionCPU;
    }

    public void setInformacionCPU(CpuInfo informacionCPU) {
        this.informacionCPU = informacionCPU;
    }

    
    
    
}
