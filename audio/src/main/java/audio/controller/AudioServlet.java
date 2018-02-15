package audio.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import audio.entity.AudioEntity;
import audio.util.AudioUtil;

/**
 * Servlet implementation class AudioServlet
 */
public class AudioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public AudioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("audio/mpeg");
String vid=request.getParameter("vid");
int v=0;
if(vid!=null)
{
	v=Integer.parseInt(vid);
}
byte[] b=AudioUtil.gestSF().openSession().get(AudioEntity.class,9).getVideo();
	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;
	try{
		bis=new BufferedInputStream(new ByteArrayInputStream(b));
		bos=new BufferedOutputStream(response.getOutputStream());
		byte[] buffer= new byte[b.length];
		int length;
		while((length=bis.read(buffer))>0){
			bos.write(buffer,0,length);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(bis!=null){
			bis.close();
		}
		if(bos!=null){
			bos.close();
		}
	}
	request.getRequestDispatcher("audio.jsp").forward(request, response);
	}

}
