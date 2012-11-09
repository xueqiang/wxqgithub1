package de.wxq.rmi.tictactoe;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Client main.
 * 
 * <br>
 * Created on 09.11.2012.
 * 
 * @author wang
 * @version $Revision: 1.2 $ $Date: 2005/03/04 08:56:01 $ $Author: wang $
 */
public class TicTacToeImpl implements TicTacToeInterface {
    private CallBack player1 = null;
    private CallBack player2 = null;

    private char[][] board = new char[3][3];


    @Override
    public char connect(CallBack client) throws RemoteException {
	if(player1==null){
	    player1=client;
	    player1.notify("Wait for a second player to join");
	    return 'X';
	} else if(player2==null){
	    player2=client;
	    player2.notify("Wait for the first player to move");
	    player2.takeTurn(false);
	    player1.notify("It is my turn (X token)");
	    player1.takeTurn(true);
	    return 'O';
	} else {
	    client.notify(" Two players are already in the game");
	    return ' ';
	}
    }

    @Override
    public void myMove(int row, int column, char token) throws RemoteException {
	board[row][column] = token;
	if (token == 'X') {
	    player2.mark(row, column, 'X');
	} else {
	    player1.mark(row, column, 'O');
	}

	if (isWon(token)) {
	    if (token == 'X') {
		player1.notify("I won!");
		player2.notify("I lost!");

		player1.takeTurn(false);
	    } else {
		player2.notify("I won!");
		player1.notify("I lost!");

		player2.takeTurn(false);
	    }
	} else if (isFull()) {
	    player1.notify("Draw!");
	    player2.notify("Draw!");
	} else if (token == 'X') {
	    player1.notify("Wait for the second player to move");
	    player1.takeTurn(false);

	    player2.notify("It is my turn, (O token");
	    player2.takeTurn(true);
	} else if (token == 'O') {
	    player2.notify("Wait for the second player to move");
	    player2.takeTurn(false);

	    player1.notify("It is my turn, (O token");
	    player1.takeTurn(true);
	}
    }

    /** Check if the board is full */
    public boolean isFull() {
	for (int i = 0; i < 3; i++)
	    for (int j = 0; j < 3; j++)
		if (board[i][j] == '\u0000')
		    return false;

	return true;
    }

    /** Check if a player with the specified token wins */
    public boolean isWon(char token) {
	for (int i = 0; i < 3; i++)
	    if ((board[i][0] == token) && (board[i][1] == token)
		    && (board[i][2] == token))
		return true;

	for (int j = 0; j < 3; j++)
	    if ((board[0][j] == token) && (board[1][j] == token)
		    && (board[2][j] == token))
		return true;

	if ((board[0][0] == token) && (board[1][1] == token)
		&& (board[2][2] == token))
	    return true;

	if ((board[0][2] == token) && (board[1][1] == token)
		&& (board[2][0] == token))
	    return true;

	return false;
    }


    /**
     * TODO Bitte Kommentar ergänzen.
     * 
     * @param args
     */
    public static void main(String[] args) {
	TicTacToeInterface obj = new TicTacToeImpl();
	try {
	    Registry registry;
	    registry = LocateRegistry.getRegistry();
	    registry.rebind("TicTacToeImpl", obj);
	} catch (RemoteException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
