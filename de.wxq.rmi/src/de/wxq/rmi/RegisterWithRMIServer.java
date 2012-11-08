package de.wxq.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Create a server object from the server implementation and register it with
 * the RMI server.<br>
 * 
 * <br>
 * Created on 08.11.2012.
 * 
 * @author wang
 * @version $Revision: 1.2 $ $Date: 2005/03/04 08:56:01 $ $Author: wang $
 */
public class RegisterWithRMIServer {
    public static void main(String[] args) {
	try {
	    final StudentServerInterface obj = new StudentServerInterfaceImpl();
	    final Registry registry = LocateRegistry.getRegistry();

	    registry.rebind("StudentServerInterfaceImpl", obj);

	    System.out.println("Student server " + obj + " registered");
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
