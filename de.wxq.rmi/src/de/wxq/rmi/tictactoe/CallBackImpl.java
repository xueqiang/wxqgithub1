package de.wxq.rmi.tictactoe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * TODO Bitte Kommentar ergänzen.
 * 
 * <br>
 * Created on 09.11.2012.
 * 
 * @author wang
 * @version $Revision: 1.2 $ $Date: 2005/03/04 08:56:01 $ $Author: wang $
 */
public class CallBackImpl extends UnicastRemoteObject implements CallBack {
    private TicTacToeClientRMI thisClient;

    protected CallBackImpl(Object client) throws RemoteException {
	super();
	thisClient = (TicTacToeClientRMI) client;
	// TODO Auto-generated constructor stub
    }

    /** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = 1L;

    @Override
    public void takeTurn(boolean turn) throws RemoteException {
	thisClient.setMyTurn(turn);
    }

    @Override
    public void notify(String message) throws RemoteException {
	thisClient.setMessage(message);
    }

    @Override
    public void mark(int row, int column, char token) throws RemoteException {
	// TODO Auto-generated method stub
	thisClient.mark(row, column, token);

    }

}
