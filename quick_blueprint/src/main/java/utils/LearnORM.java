package utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LearnORM {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		HibernateUtil.loadConfig("src/main/resources/connection.properties");//load once Hibernate configuration 
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Question question = new Question("this is coll", new String[] { "yes", "no", "maybe" });
//
//			session.save(question);
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//
//		QuestionDAO qdao = new QuestionDAO();
//	
//		for (Question que : qdao.fetchQuestions()) {
//			System.out.println(que.getQuestionText() +" : "+que.getAnswers()+" : ");
//		}
		
		try {
			throw new Exception("!23");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception");
		}finally {
			System.out.println("and finnaly");
		}

	}

}
