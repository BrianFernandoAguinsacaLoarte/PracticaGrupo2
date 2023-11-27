
package controlador.dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;


public class Connection {
    
    public static String URL = "data"+File.separatorChar;
    public static XStream xstream;
    
    //Constructor
    public Connection(){
    }
    
    //Getter and Setter

    public static String getURL() {
        return URL;
    }
    
    public static void setURL(String URL) {
        Connection.URL = URL;
    }

    public static XStream getXstream() {
        
        if(xstream == null){
            xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.addPermission(AnyTypePermission.ANY);
        }
        return xstream;
    }

    public static void setXstream(XStream xstream) {
        Connection.xstream = xstream;
    }
    
    
}
