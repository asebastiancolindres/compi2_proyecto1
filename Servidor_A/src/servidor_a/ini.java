/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor_a;

import java.io.File;

/**
 *
 * @author sebastian
 */
public class ini {
    
    public static String DS  = File.separator;
    public static String dir = System.getProperty("user.dir")+DS+"src"+DS+"archivosXML"+DS;
    public static String dir_mensajes = dir+"mensajes"+DS;
    public static String usuarios_xml = dir+"UsuariosServidorA.xml";
}
