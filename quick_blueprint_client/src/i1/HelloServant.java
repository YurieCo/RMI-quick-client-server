/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i1;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author pgi
 */

public class HelloServant extends UnicastRemoteObject implements IHelloService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3181239280075383922L;
	
	
	private Long id;
	
	public String name;
	public String message;

	public HelloServant() throws RemoteException {
		super();
	}
	
	
	private String getName() {
		return name;
	}



	private void setName(String name) {
		this.name = name;
	}



	private String getMessage() {
		return message;
	}



	private void setMessage(String message) {
		this.message = message;
	}



	

	@Override
	public String echo(String input) throws RemoteException {
		System.out.println("input " + input);
		return "return from server " + input;
	}

	
	@Override
	public List<HelloServant> getHistory() throws RemoteException {
		return null;
	}

}
