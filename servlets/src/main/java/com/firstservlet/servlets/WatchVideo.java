package com.firstservlet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuggle.mediatool.IMediaListener;
import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaViewer;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.IError;

public class WatchVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WatchVideo() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName ="E:\\ankit\\Jumme_Ki_Raat_(Kick)_Full_HD(wapking.cc).mp4";
		IMediaReader reader=ToolFactory.makeReader(fileName);
		reader.addListener(ToolFactory.makeViewer(IMediaViewer.Mode.AUDIO_VIDEO));
	reader.addListener(ToolFactory.makeWriter("./video.html", reader));
		
				request.setAttribute("er",reader);
				request.getRequestDispatcher("video.html").forward(request,response); 
	
	}

}
