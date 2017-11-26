/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBitacora;

/**
 *
 * @author neko__000
 */
public class Registro {
    private String Nivel;
    private String descripcionRegistro;
    private String fechaRegistro;
    private String versionFramework;
    private String informacionSO;
    private String informacionMaquina;
    private String datoAdicional;

    public Registro(String Nivel, String descripcionRegistro, String fechaRegistro, String versionFramework, String informacionSO, String informacionMaquina) {
        this.Nivel = Nivel;
        this.descripcionRegistro = descripcionRegistro;
        this.fechaRegistro = fechaRegistro;
        this.versionFramework = versionFramework;
        this.informacionSO = informacionSO;
        this.informacionMaquina = informacionMaquina;
    }

    /**
     * @return El Nivel del Registro
     */
    public String getNivel() {
        return Nivel;
    }

    /**
     * @param Nivel the Nivel to set
     */
    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    /**
     * @return the descripcionRegistro
     */
    public String getDescripcionRegistro() {
        return descripcionRegistro;
    }

    /**
     * @param descripcionRegistro the descripcionRegistro to set
     */
    public void setDescripcionRegistro(String descripcionRegistro) {
        this.descripcionRegistro = descripcionRegistro;
    }

    /**
     * @return the fechaRegistro
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the versionFramework
     */
    public String getVersionFramework() {
        return versionFramework;
    }

    /**
     * @param versionFramework the versionFramework to set
     */
    public void setVersionFramework(String versionFramework) {
        this.versionFramework = versionFramework;
    }

    /**
     * @return the informacionSO
     */
    public String getInformacionSO() {
        return informacionSO;
    }

    /**
     * @param informacionSO the informacionSO to set
     */
    public void setInformacionSO(String informacionSO) {
        this.informacionSO = informacionSO;
    }

    /**
     * @return the informacionMaquina
     */
    public String getInformacionMaquina() {
        return informacionMaquina;
    }

    /**
     * @param informacionMaquina the informacionMaquina to set
     */
    public void setInformacionMaquina(String informacionMaquina) {
        this.informacionMaquina = informacionMaquina;
    }

    /**
     * @return the datoAdicional
     */
    public String getDatoAdicional() {
        return datoAdicional;
    }

    /**
     * @param datoAdicional the datoAdicional to set
     */
    public void setDatoAdicional(String datoAdicional) {
        this.datoAdicional = datoAdicional;
    }
    
    
}
