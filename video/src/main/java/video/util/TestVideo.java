package video.util;

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

import video.entity.VideoEntity;

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
		File file =new File("video2.mp4");
		FileInputStream fis=new FileInputStream(file);
	    byte[] b=new byte[(int)file.length()];
	    fis.read(b);
	    VideoEntity vp=new VideoEntity();
	    vp.setVideo(b);
	    vp.setVname("video2");
	    hsession.save(vp);
		
tx.commit();
hsession.close();
sf.close();
	}

}
