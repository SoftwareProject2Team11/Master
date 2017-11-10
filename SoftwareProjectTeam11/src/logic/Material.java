package logic;

public class Material {
	private int materialID;
	private int trainingID;
	private String title;
	private int ISBN;
	private String author;
	private String type;
	
	
	public Material(int ISBN,int trainingID,String author,String title,String type)
	{
		this.materialID++;
		this.setTrainingID(trainingID);
		this.setTitle(title);
		this.setAuthor(author);
		this.setISBN(ISBN);
		this.setType(type);
	}
	public int getTrainingID() {
		return trainingID;
	}
	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}
	public int getMaterialID()
	{
		return this.materialID;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle()
	{
		return this.title;
		
	}
	public String getAuthor()
	{
		return this.author;
	}
	public int getISBN()
	{
		return this.ISBN;
	}
	public void setISBN(int ISBN)
	{
		this.ISBN=ISBN;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	
	
	
	
	
}
