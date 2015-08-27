package ua.pp.msk.forfin.greeter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maskimko
 */
@Named(value = "greeter")
@Dependent
public class Greeter implements Serializable{

    @Inject
    private JMetter j;
    /**
     * Creates a new instance of Greeter
     */
    public Greeter() {
    }

   
    
    public String startTest(){
        j.run();
        return "#";
    }
    
    public String getError(){
        return j.getError();
    }
    
    public String getOutput(){
        return j.getOutput();
    }
    
    public String getIpAddress() {
        String addr = null;
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                if (n.getDisplayName().equals("lo")) {
                    continue;
                }
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    LoggerFactory.getLogger(this.getClass()).debug("Found IP address " + i.getHostAddress() + " on " + n.getDisplayName());
                    addr = i.getHostAddress();
                }
            }

        } catch (SocketException ex) {
            LoggerFactory.getLogger(this.getClass()).error("Cannot determine host ip address " + ex.getMessage(), ex);
        }
        return addr;
    }
}
