package com.mobilelife.common;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class GeekCodes {

	public String encrypt(String secretKey, String saltKey, String strToEncrypt)
	{
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), saltKey.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKeyx = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKeyx, ivspec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
	
	public String decrypt(String secretKey, String saltKey, String strToDecrypt) {
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), saltKey.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKeyx = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKeyx, ivspec);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    }
	    catch (Exception e) {
	        System.out.println("Error while decrypting: " + e.toString());
	    }
	    return null;
	}
	
	public static void main(String[] args)
	{
	    String originalString = "HippoInnovations|8FRx1lUJD8|store";
		String secretKey = "HIPPOKEY";
		String salt = "HIPPOSALT";
	    GeekCodes geekCodes = new GeekCodes();
	    String encryptedString = geekCodes.encrypt(secretKey, salt, originalString) ;
//	    String encryptedString = "en6qkgkf5zLyUACf994g9Oyrr6DlxYvLWFNqYPpVG" ;//geekCodes.encrypt(secretKey, salt, originalString) ;
//	    
	    String decryptedString = geekCodes.decrypt(secretKey, salt, encryptedString) ;
//	      
	    System.out.println(originalString);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
//		System.out.println((200*10)/100);

//	    System.out.println((400-(300+40))+"  --- "+(400 -(200)));

	}
}
