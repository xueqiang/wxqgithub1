package de.wxq.rmi.tictactoe;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * For clients.
 * 
 * <br>
 * Created on 09.11.2012.
 * 
 * @author wang
 * @version $Revision: 1.2 $ $Date: 2005/03/04 08:56:01 $ $Author: wang $
 */
public interface TicTacToeInterface extends Remote {

    public char connect(CallBack client) throws RemoteException;

    public void myMove(int row, int column, char token) throws RemoteException;
}
