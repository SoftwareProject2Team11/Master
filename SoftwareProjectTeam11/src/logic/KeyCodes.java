package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KeyCodes")
public class KeyCodes {
	
	@Id
	@Column(name="keyCodeId")
	private int keyCodeId;	
	@Column(name="keyCode")
	private String keyCode;
	@Column(name="used")
	private int used;
	
	
	public KeyCodes(int keyCodeId, String keyCode, int used) {
		super();
		this.keyCodeId = keyCodeId;
		this.keyCode = keyCode;
		this.used = used;
	}


	public KeyCodes() {
		super();
	}


	public String getKeyCode() {
		return keyCode;
	}


	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}


	public int getUsed() {
		return used;
	}


	public void setUsed(int used) {
		this.used = used;
	}
	
	
	
	

}
