package de.wxq.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Server object interface.<br>
 * <br>
 * Created on 08.11.2012.
 * 
 * @author wang
 * @version $Revision: 1.2 $ $Date: 2005/03/04 08:56:01 $ $Author: wang $
 */
public interface StudentServerInterface extends Remote {
    public double findScore(String name) throws RemoteException;
}
