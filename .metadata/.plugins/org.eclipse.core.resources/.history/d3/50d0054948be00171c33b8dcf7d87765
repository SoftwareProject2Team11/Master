package logic;

public class Login {
	private int loginId;
	private String username;
	private String password;
	
	
	public String getUsername()
	{
		
	return this.username;	
	
	}
	public bool Connect(String username,String password)
	{
		/*
		 * Mogelijkheid 1 voor hash password
		 * MessageDigest digest = MessageDigest.getInstance("SHA-256");
		 *byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
		 * Mogelijkheid 2 voor hash password
		 * String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(stringText); 
		 *Wat het eigenlijk moet doen: 
		 * password= sha256(password);
		  */
		if(this.password==password && this.username==username)
		{
			return true;
		}
		else 
		{
			return false;
		}
		}
	/* Mogelijkheid voor sha256 hash
	 * public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}
*Andere mogelijkheden in de links in het Referenties document
*/
	
	
	
}
