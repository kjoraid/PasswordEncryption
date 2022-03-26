import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*
    This class is responsible of:
    A) Encrypt data passed by Array by following these steps: 
        1- Check if the array is having  data
        2- Call the Encrypt class to encrypt the data
        3- Return the array with encrypted details
    B) Decrypt data passed by an Array by following these steps:
        1- Check if the array is having  data
        2- Call the Decrypt class to encrypt the data
        3- Return the array with Decrypted details
*/
public class EncryptDecrypt {
    
public String encrypt(String strClearText,String strKey) throws Exception{
	String strData="";
	
	try {
        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
		Cipher cipher=Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
		byte[] encrypted=cipher.doFinal(strClearText.getBytes());
		strData=new String(encrypted);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e);
	}
	return strData;
    }

    public String decrypt(String strEncrypted,String strKey) throws Exception{
        String strData="";
        
        try {
            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
            strData=new String(decrypted);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }
}
