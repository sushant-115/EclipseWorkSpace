package video;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestVideo {

	public static void main(String[] args) throws IOException {
		Configuration cfg =new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session hsession =sf.openSession();
		Transaction tx=hsession.beginTransaction();
	/**	byte[] b=	hsession.get(VideoProfile.class, 1).getVideo();
		File file=new File("audio.mp3");
		
		FileOutputStream fos=new FileOutputStream(file);
		BufferedOutputStream bis=new BufferedOutputStream(fos);
	
		fos.write(b);
		fos.flush();
		**/
		File file =new File("abcd.mp3");
		FileInputStream fis=new FileInputStream(file);
	    byte[] b=new byte[(int)file.length()];
	    fis.read(b);
	    VideoProfile vp=new VideoProfile();
	    vp.setVideo(b);
	    vp.setvName("Apun ki tu");
	    hsession.save(vp);
		
tx.commit();
hsession.close();
sf.close();
	}

}
