/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import utils.HibernateUtil;

/**
 *
 * @author pgi
 */
public class ApplicationServer {
	/*
	 * following method is used to parametters for CLASSPATH
	 */
	
	public static void main(String[] args) throws RemoteException {

//		SecurityManager securityManagment = new SecurityManager();
//		System.setProperty("java.security.policy", "file:./security.policy");
//		System.setSecurityManager(securityManagment);
		String level = IHelloService.class.getCanonicalName();
		System.out.println(level);
		
		
		System.setProperty("CLASSPATH", "target/bin "+level);

		Registry registry = LocateRegistry.createRegistry(5099);
		HibernateUtil.loadConfig("src/main/resources/connection.properties");

		HelloServant servantObj = new HelloServant();
		servantObj.name = "remote object";
		registry.rebind("hello", servantObj);
	}
}
