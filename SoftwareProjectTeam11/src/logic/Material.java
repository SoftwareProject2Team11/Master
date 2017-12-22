package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Material")
public class Material {
	@Id
	@Column(name = "materialId")
	private int materialId;
	@Column(name = "trainingId")
	private int trainingId;
	@Column(name = "title")
	private String title;

	public Material(int materialId, int trainingId, String title) {
		super();
		this.materialId = materialId;
		this.trainingId = trainingId;
		this.title = title;
	}

	public Material() {

	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
