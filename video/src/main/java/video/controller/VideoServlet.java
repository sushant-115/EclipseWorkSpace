package video.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.hibernate.Session;

import com.xuggle.mediatool.IMediaCoder;
import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.IContainer;

import video.entity.VideoEntity;
import video.util.VideoUtil;

public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       File file;
      public VideoServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String range=request.getHeader("range");
		String browser=request.getHeader("User-Agent");
		Integer vid=Integer.parseInt(request.getParameter("vid"));
		String fileName="video2.mp4";
		Session hs=VideoUtil.gestSF().openSession();
		response.setContentType("video/mp4");
		VideoEntity ve=hs.get(VideoEntity.class,vid);
		byte[] b=ve.getVideo();
		
		
	
	OutputStream bos=null;
	response.setContentLength(b.length);
	response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
	response.setHeader("Content-Range", range +Integer.valueOf(b.length-1));
	response.setHeader("Accept-Ranges", "bytes");
	response.setHeader("Etag","W/\"9767057-1323779115364\"");
	try{
		
		bos=new BufferedOutputStream(response.getOutputStream());
			bos.write(b);
	}
		catch(Exception e){
			e.printStackTrace();
		}
	finally{
		
		if(bos!=null){
			bos.close();
			hs.close();
			
		}
	}
	request.getRequestDispatcher("./video.html").forward(request, response);
	}
	public void destroy(){
file.delete();
	}
	}

	

