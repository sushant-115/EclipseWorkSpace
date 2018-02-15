package video.entity;

import javax.persistence.*;

@Entity
@Table(name="videoentity")
public class VideoEntity {
	@Id
	@GeneratedValue
	private Integer vid;
	private String vname;
	@Lob
	private byte[] video;
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public byte[] getVideo() {
		return video;
	}
	public void setVideo(byte[] video) {
		this.video = video;
	}
	

}
