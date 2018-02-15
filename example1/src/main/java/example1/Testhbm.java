package example1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.internal.CharacterStreamImpl;
import org.hibernate.query.Query;

public class Testhbm {

	public static <E> void main(String[] args) throws IOException {
	Configuration cfg=new Configuration();
	cfg.configure();
	SessionFactory sf=cfg.buildSessionFactory();
	Session hsession=sf.openSession();
	Transaction tx=hsession.beginTransaction();
/**Questions<E> ques=new Questions<E>();
	ArrayList<String> a=new ArrayList<String>();
	ques.setQuestion("What is the output of following code?");
	File file=new File("file.txt");
	FileReader fr=new FileReader(file);
	CharacterStreamImpl csi=new CharacterStreamImpl(fr, file.length());
	char[] c=new char[(int) file.length()];
	fr.read(c); **/
	
	
	Query query =hsession.createQuery("From Questions");
	query.setMaxResults(10);
List<Questions> list=query.list();
Collections.shuffle(list);
	for(Questions q:list){
		CopyOfQuestions<E> coq=new CopyOfQuestions<>();
		coq.setQuestion(q.getQuestion());
		coq.setQtype(q.getQtype());
		coq.setQid(q.getQid());
		coq.setAnswer1(q.getAnswer1());
		coq.setAnswer2(q.getAnswer2());
		coq.setAnswer3(q.getAnswer3());
		coq.setAnswer4(q.getAnswer4());
		coq.setCode(q.getCode());
		coq.setRealAnswer(q.getRealAnswer());
		hsession.save(coq);
		
	}
	
	tx.commit();
	hsession.close();
	
	
	
	}

}
