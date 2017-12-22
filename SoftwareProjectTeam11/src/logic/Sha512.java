package logic;

import java.security.*;
import javax.xml.bind.DatatypeConverter;

public class Sha512 {
	
	

	public String hashPassword(String password)
	{
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(password.getBytes(),0,password.length());
			byte[] digestedBytes = messageDigest.digest();
			
			password = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
		//	password = password.substring(15, 30);
			return password;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Unexpected error");
	}
}
