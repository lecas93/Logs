package controladorBitacora;

import java.net.UnknownHostException;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * Clase que obtiene la información referente al hardware de la computadora que
 * utiliza el framework
 *
 * @author Samuel Aké Tello y Andrés Castellanos
 */
public class InformacionMaquina {

    private String versionFrameWork = "1.0";
    private OperatingSystem informacionSO;
    private CpuInfo informacionCPU;

    public InformacionMaquina() {
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

    /**
     * Método que obtiene la información de la computadora, en concreto el
     * nombre establecido para la computadora y su dirección ip.
     *
     * @return Retorna la informacion del equipo descrita anteriormente.
     */
    public String obtenerInformacionEquipo() {
        String informacionMaquina = "";
        informacionMaquina = " - INFORMACION MAQUINA: " + obtenerNombreEquipo()
                + obtenerDireccionIP();
        return informacionMaquina;
    }

    /**
     * Método que obtiene información del sistema operativo, en concreto el
     * nombre del SO, la arquitectura del procesadora, la versión del SO y la
     * información del CPU.
     *
     * @return Retorna la información del SO descrita anteriormente.
     */
    public String obtenerInformacionSO() {
        String informacionSO = "";
        informacionSO = obtenerNombreSO() + obtenerArquitecturaSO() + obtenerVersionSO()
                + obtenerInformacionCPU();
        return informacionSO;
    }

    /**
     * Método que obtiene la dirección IP asignada.
     *
     * @return Retorna la dirección IP.
     */
    private String obtenerDireccionIP() {
        try {
            return " - IP = " + java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            return " - IP = 0.0.0.0";
        }
    }

    /**
     * @return Retorna el nombre del SO.
     */
    private String obtenerNombreSO() {
        return " Sistema Operativo = " + getInformacionSO().getDescription();
    }

    /**
     * @return Retorna la arquitectura del procesador.
     */
    private String obtenerArquitecturaSO() {
        return " - Arquitectura SO = " + getInformacionSO().getArch();
    }

    /**
     * @return Retorna la versión del SO.
     */
    private String obtenerVersionSO() {
        return " - Version SO = " + getInformacionSO().getVersion();
    }

    /**
     * @return Retorna la versión del framework.
     */
    private String obtenerVersionFramework() {
        return "Version BitacoraLog = " + this.versionFrameWork;
    }

    /**
     * @return Retorna el nombre del equipo asignado al usuario.
     */
    private String obtenerNombreEquipo() {
        try {
            return " - Nombre Equipo = " + java.net.InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException ex) {
            return " - Nombre Equipo = SinNombre";
        }
    }

    /**
     * @return Retorna la información referente al CPU.
     */
    private String obtenerInformacionCPU() {
        String informacionCPU = "";
        informacionCPU = "- INFORMACION CPU: Vendedor : " + getInformacionCPU().getVendor()
                + " - Modelo : " + getInformacionCPU().getModel() + " - Frecuencia (Mhz): "
                + getInformacionCPU().getMhz();
        return informacionCPU;

    }

    /**
     * @return Retorna información referente al SO.
     */
    public OperatingSystem getInformacionSO() {
        return informacionSO;
    }

    /**
     * @param informacionSO Asigna la informacionSO proporcionada a la variable de esta clase.
     */
    public void setInformacionSO(OperatingSystem informacionSO) {
        this.informacionSO = informacionSO;
    }

    /**
     * @return Retorna información referente al CPU.
     */
    public CpuInfo getInformacionCPU() {
        return informacionCPU;
    }
/**
     * @param informacionCPU Asigna la informacionCPU proporcionada a la variable de esta clase.
     */
    public void setInformacionCPU(CpuInfo informacionCPU) {
        this.informacionCPU = informacionCPU;
    }

}
