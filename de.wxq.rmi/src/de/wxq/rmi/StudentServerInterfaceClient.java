package de.wxq.rmi;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JApplet;

/**
 * An applet as a client of RMI.<br>
 * 
 * <br>
 * Created on 08.11.2012.
 * 
 * @author wang
 * @version $Revision: 1.2 $ $Date: 2005/03/04 08:56:01 $ $Author: wang $
 */
public class StudentServerInterfaceClient extends JApplet {

    /** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = 1L;

    private StudentServerInterface student;

    /** applet or application */
    private boolean isStandalone;

    @Override
    public void init() {
	initializeRMI();

    }

    private void initializeRMI() {
	String host = " ";

	if (!isStandalone) {
	    final URL codeBase = getCodeBase();
	    host = codeBase.getHost();
	}
	
	try {
	    final Registry registry = LocateRegistry.getRegistry(host);
	    String remotrRefName="StudentServerInterfaceImpl";
	    student = (StudentServerInterface) registry.lookup(remotrRefName);

	    System.out.println("Server object " + student + " found.");
	} catch (RemoteException | NotBoundException e) {
	    e.printStackTrace();
	}

    }
}
