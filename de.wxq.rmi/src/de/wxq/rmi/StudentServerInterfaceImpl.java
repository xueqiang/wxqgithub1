package de.wxq.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Server implementation class. <br>
 * Created on 08.11.2012.
 * 
 * @author wang
 * @version $Revision: 1.2 $ $Date: 2005/03/04 08:56:01 $ $Author: wang $
 */
public class StudentServerInterfaceImpl extends UnicastRemoteObject implements
	StudentServerInterface {
    private HashMap<String, Double> scores = new HashMap<String, Double>();

    protected StudentServerInterfaceImpl() throws RemoteException {
	super();
	initializeStudent();
    }

    private void initializeStudent() {
	scores.put("John", new Double(90.5));
	scores.put("Michael", new Double(100));
	scores.put("Michelle", new Double(98.5));
    }

    /** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = 1L;

    @Override
    public double findScore(final String name) throws RemoteException {
	Double d = (Double) scores.get(name);

	if (d == null) {
	    System.out.println("Student " + name + " is not found ");
	    return -1;
	} else {
	    System.out.println("Student " + name + "\'s score is "
		    + d.doubleValue());
	    return d.doubleValue();
	}
    }

}
