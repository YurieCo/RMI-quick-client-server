/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pgi
 */
public class Client {

    public static void main(String[] args) {
        try {
        	
        	IHelloService serviceObj = (IHelloService) Naming.lookup("rmi://localhost:5099/hello");
            System.out.println("obj " + serviceObj.echo("hey server"));
            
            for (IHelloService ih: serviceObj.getHistory()) {
            	System.out.println(ih);
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
