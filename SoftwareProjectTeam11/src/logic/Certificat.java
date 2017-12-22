package logic;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import db.CertificatDAO;

import db.CertificatDAO;

@Entity
@Table
public class Certificat  {
	@Id
	@Column(name="certificatId")
	private int certificatId;
	
	@Column(name="trainingId")
	private int trainingId;
	
	@Column(name="certificatName")
	private String certificatName;
	
	@Column(name="certificaat")
	private byte[] certificaat;
	
	@Column(name="extensie")
	private String extensie;

	public Certificat(int certificatId, int trainingId, String certificatName, byte[] certificaat, String extensie) {

	
		super();
		this.certificatId = certificatId;
		this.trainingId = trainingId;
		this.certificatName = certificatName;

		this.certificaat = certificaat;
		this.extensie=extensie;
	

	}
	

	public String getExtensie() {
		return extensie;
	}


	public void setExtensie(String extensie) {
		this.extensie = extensie;
	}


	public Certificat() {
		super();
	}

	public int getCertificatId() {
		return certificatId;
	}

	public void setCertificatId(int certificatId) {
		this.certificatId = certificatId;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getCertificatName() {
		return certificatName;
	}

	public void setCertificatName(String certificatName) {
		this.certificatName = certificatName;
	}

	public byte[] getCertificaat() {
		return certificaat;
	}

	public void setCertificaat(byte[] certificaat) {
		this.certificaat = certificaat;
	}
	
}

