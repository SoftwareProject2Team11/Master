package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import logic.Login;
import logic.Sha512;


public class LoginDAO extends BaseDAO {
	
	public boolean addLogin(String username,String password)
	{
		PreparedStatement ps = null;
		Random r= new Random();
		int salt = r.nextInt(99);
		System.out.println(salt);
		String stringToHash = password + salt;
		password = new Sha512().hashPassword(stringToHash);
		//System.out.println(password + ":  " + salt);
		String sql = "INSERT INTO Login VALUES(null,?,?, " + salt + ")";
		
		try
		{
			if(getConnection().isClosed())
			{
				throw new RuntimeException("Connection is closed");
			}
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			if (ps.executeUpdate() == 0) {
				ps.close();
				return false;
			}
			else
			{
				ps.close();
				return true;
			}
			
		} catch(SQLException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			try 
			{
				if(ps != null)
				ps.close();

			}
			catch(SQLException e) 
			{
				System.out.println(e.getMessage());;
				throw new RuntimeException("Unexpected Error!");
			}
		}
	}
	
	
	public boolean checkLogin(String username,String password)
	{
		PreparedStatement ps = null;
		int salt = getSaltByUsername(username);
		password = new Sha512().hashPassword(password + salt);
		String sql = "SELECT * FROM Login WHERE username = ? AND password = ?";
		
		try
		{
			if(getConnection().isClosed())
			{
				throw new RuntimeException("Connection is closed");
			}
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs =  ps.executeQuery();
			Login login = null;
			while(rs.next()) {
			login = new Login(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			if(login == null){
				return false;
			}
			else if(login.getUsername().equals(username) && login.getPassword().equals(password))
			{
			return true;
			}
			return false;
			
		} 
		catch(SQLException e)
		{
			
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			try 
			{
				if(ps != null)
				ps.close();

			}
			catch(SQLException e) 
			{
				System.out.println(e.getMessage());;
				throw new RuntimeException("Unexpected Error!");
			}
		}
		
	}
	
	public int getSaltByUsername(String username)
	{
		PreparedStatement ps = null;
		String sql = "SELECT salt FROM Login WHERE username = ? ";
		try
		{
			if(getConnection().isClosed())
			{
				throw new RuntimeException("Connection is closed");
			}
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs =  ps.executeQuery();
			int salt = -1;
			@SuppressWarnings("unused")
			Login login = null;
			while(rs.next()) {
				salt = rs.getInt(1);
			}
			return salt;
		} 
		catch(SQLException e)
		{	
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			try 
			{
				if(ps != null)
				ps.close();
			}
			catch(SQLException e) 
			{
				System.out.println(e.getMessage());;
				throw new RuntimeException("Unexpected Error!");
			}
		}
	}

}
