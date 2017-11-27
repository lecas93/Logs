/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaBitacora;

import vistaBitacora.ConfigurarBitacora;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase que envía los registros por correo electronico
 * @author Samuel Ake y Andrés Castellanos
 * @version 26112017
 * 
 */
public class EstructuraMensaje {
    private String usuario;
    private String contraseña;

    public EstructuraMensaje() {
        establecerCredenciales();
    }
    
   /**
 *
 * @param asunto Texto que defino el asunto del e-mail
 * @param cuerpo Texto que va dentro del mensaje
 * 
 */
    public void sendEmail(String asunto, String cuerpo) {
    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        String remitente = getUsuario();  //Para la dirección nomcuenta@gmail.com

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "miClaveDeGMail");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(getUsuario() + "@gmail.com"));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, getContraseña());
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
    /**
 *
 * @see setUsuario()
 * @see setContraseña()
 * 
 */
    private void establecerCredenciales(){
        try {
            setUsuario(new ConfigurarBitacora().obtenerConfiguracionXML("CorreoElectronico"));
            setContraseña(new ConfigurarBitacora().obtenerConfiguracionXML("ContraseñaCorreo"));
        } catch (Exception e){
            //Colocar Despues
        }
    }

    public String getUsuario() {
        return usuario;
    }
 /**
 *
 * @param usuario Correo electronico sin el dominio 
 * 
 */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
/**
 *
 * @param contraseña Contraseña brindada por el usuario correspondiente al e-mail.
 * 
 */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
}
