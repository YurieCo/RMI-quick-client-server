/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author pgi
 */
public interface IHelloService extends Remote{

	public String echo(String input) throws RemoteException;
	public List<HelloServant> getHistory() throws RemoteException;

}
