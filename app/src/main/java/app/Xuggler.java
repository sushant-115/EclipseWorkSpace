package app;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaViewer;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;

public class Xuggler{
	public static void main(String[] args) {
		String fileName ="E:\\ankit\\Jumme_Ki_Raat_(Kick)_Full_HD(wapking.cc).mp4";
		IMediaReader reader=ToolFactory.makeReader(fileName);
		reader.addListener(ToolFactory.makeViewer(IMediaViewer.Mode.AUDIO_VIDEO));
		while(reader.readPacket()==null)
			do{}while(false);
	}
}