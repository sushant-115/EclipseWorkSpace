package audio.entity;

import javax.persistence.*;

@Entity
@Table(name="videoprofile")
public class AudioEntity {
	@Id
	@Column(name="vid")
	private Integer vid;
	@Column(name="vname")
	private String vname;
	@Column(name="video")
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
