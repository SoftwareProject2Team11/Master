package logic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Material")
public class Material {
	@Id
	private int materialID;
	private String title;
	private int ISBN;
	private String author;
	
	public Material(int ISBN,String author,String title)
	{
		this.materialID++;
		this.setTitle(title);
		this.setAuthor(author);
		this.setISBN(ISBN);
	}
	//deze zou eigenlijk niet mogen gebruikt door de gebruiker/andere klasses buiten de DAO's worden maar wordt gebruikt om een instantie te maken binnen MaterialDAO
	public Material()
	{
		
	}
	public void setMaterial(String title, int ISBN,String author)
	{
		this.setTitle(title);
		this.setISBN(ISBN);
		this.setAuthor(author);
		
	}
	public int getMaterialID()
	{
		return this.materialID;
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

