
package modeloBitacora;

/**
 * Clase que ayuda a modelar el guardado de lpos registros
 *
 * @author Samuel Ake y Andrés Castellanos
 */
public class Registro {

    private String Nivel;
    private String descripcionRegistro;
    private String fechaRegistro;
    private String versionFramework;
    private String informacionSO;
    private String informacionMaquina;
    private String datoAdicional;

    /**
     *@param Nivel Nivel del mensaje definido para el registro.
     *@param descripcionRegistro Descripcion del registro a generado.
     *@param fechaRegistro Fecha en la que se generó dicho registro.
     *@param versionFramework Version actual del framework.
     *@param informacionSO Información relevante para el registro, en este caso del Sistema operativo.
     *@param informacionMaquina Información relevante para el registro, referente al hardware.
     */
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
     * @param Nivel Nivel a establecer.
     */
    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    /**
     * @return Retorna la descripción del registro.
     */
    public String getDescripcionRegistro() {
        return descripcionRegistro;
    }

    /**
     * @param descripcionRegistro Descripción del registro a establecer.
     */
    public void setDescripcionRegistro(String descripcionRegistro) {
        this.descripcionRegistro = descripcionRegistro;
    }

    /**
     * @return Retorna la fecha en la que se generó el registro.
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro La fecha del registro a establecer.
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return Retorna La versión actual del framework.
     */
    public String getVersionFramework() {
        return versionFramework;
    }

    /**
     * @param versionFramework La versión del framework a establecer.
     */
    public void setVersionFramework(String versionFramework) {
        this.versionFramework = versionFramework;
    }

    /**
     * @return Retorna la información del sistema operativo.
     */
    public String getInformacionSO() {
        return informacionSO;
    }

    /**
     * @param informacionSO La información del sistema operativo a establecer.
     */
    public void setInformacionSO(String informacionSO) {
        this.informacionSO = informacionSO;
    }

    /**
     * @return Retorna la información del hardware.
     */
    public String getInformacionMaquina() {
        return informacionMaquina;
    }

    /**
     * @param informacionMaquina La informacion del hardware a establecer.
     */
    public void setInformacionMaquina(String informacionMaquina) {
        this.informacionMaquina = informacionMaquina;
    }

    /**
     * @return Retorna la información adicional.
     */
    public String getDatoAdicional() {
        return datoAdicional;
    }

    /**
     * @param datoAdicional Información adicional a establecer.
     * */
    public void setDatoAdicional(String datoAdicional) {
        this.datoAdicional = datoAdicional;
    }

}
