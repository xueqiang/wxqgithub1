package de.wxq.rmi.tictactoe;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * For server.
 * 
 * <br>
 * Created on 09.11.2012.
 * 
 * @author wang
 * @version $Revision: 1.2 $ $Date: 2005/03/04 08:56:01 $ $Author: wang $
 */
public interface CallBack extends Remote {
    /** The server notifies the client for taking a turn */
    public void takeTurn(boolean turn) throws RemoteException;

    /** The server sends a message to be displayed by the client */
    public void notify(String message) throws RemoteException;

    /** The server notifies a client of the other player's move */
    public void mark(int row, int column, char token) throws RemoteException;
}
