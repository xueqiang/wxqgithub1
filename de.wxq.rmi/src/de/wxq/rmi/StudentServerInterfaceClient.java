package de.wxq.rmi;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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

    private JButton jbtGetScore = new JButton("Get Score");
    private JTextField jtfName = new JTextField();
    private JTextField jtfScore = new JTextField();

    @Override
    public void init() {
	initializeRMI();

	JPanel jPanel1 = new JPanel();
	jPanel1.setLayout(new GridLayout(2, 2));
	jPanel1.add(new JLabel("Name"));
	jPanel1.add(jtfName);
	jPanel1.add(new JLabel("Score"));
	jPanel1.add(jtfScore);

	add(jbtGetScore, BorderLayout.SOUTH);
	add(jPanel1, BorderLayout.CENTER);

	jbtGetScore.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent evt) {
		getScore();
	    }
	});
    }

    private void getScore() {
	double score;
	try {
	    score = student.findScore(jtfName.getText().trim());

	    if (score < 0) {
		jtfScore.setText("Not found");
	    } else {
		jtfScore.setText(String.valueOf(score));
	    }

	} catch (RemoteException e) {
	    e.printStackTrace();
	}
    }

    private void initializeRMI() {
	String host = "localhost";

	if (!isStandalone) {
	    final URL codeBase = getCodeBase();
	    host = codeBase.getHost();
	    System.out.println("Host: " + host);
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

    public static void main(String[] args) {
	StudentServerInterfaceClient applet = new StudentServerInterfaceClient();
	applet.isStandalone = true;

	JFrame frame = new JFrame();
	frame.setTitle("StudentServerInterfaceClient");
	frame.add(applet, BorderLayout.CENTER);
	frame.setSize(250, 150);
	applet.init();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
