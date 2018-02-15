package video.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuggle.ferry.IBuffer;
import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaViewer;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.ICodec.Type;
import com.xuggle.xuggler.IContainer;
import com.xuggle.xuggler.IPixelFormat;
import com.xuggle.xuggler.IRational;
import com.xuggle.xuggler.IVideoPicture;

public class CallerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public CallerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBuffer buffer =new IBuffer(0,true);
		
		IMediaReader reader=ToolFactory.makeReader(IContainer.make());
		reader.addListener(ToolFactory.makeViewer(IMediaViewer.Mode.AUDIO_VIDEO));
		IMediaWriter writer=ToolFactory.makeWriter("http://10.10.0.187:8080/video/video.html",reader);
	while(reader.readPacket()!=null){
	do{writer.addVideoStream(0, 0,ICodec.ID.CODEC_ID_MPEG4,0, 0);
	 writer.encodeVideo(0,IVideoPicture.make(buffer, IPixelFormat.Type.VDPAU_MPEG4, 300, 300));  
}while(false);
}
 request.setAttribute("writer",writer);
   
   request.getRequestDispatcher("http://10.10.0.187:8080/video/video.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
