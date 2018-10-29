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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

/**
 *
 * @author pgi
 */

@Entity
public class HelloServant extends UnicastRemoteObject implements IHelloService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3181239280075383922L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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



	private void saveEntity(String loging_text) {
		this.message = loging_text;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(this);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public String echo(String input) throws RemoteException {
		saveEntity(input);
		System.out.println("input " + input);
		return "return from server " + input;
	}

	
	@Override
	public List<HelloServant> getHistory() throws RemoteException {
		List<HelloServant> servants = null;
		Session session =  HibernateUtil.getSessionFactory().openSession();
		try  {
			session.beginTransaction();
			servants = (List<HelloServant>) session.createQuery("from HelloServant").list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return servants;
	}

}
