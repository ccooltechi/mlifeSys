package com.mobilelife.controler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.mobilelife.api.beans.AuthRequest;
//import com.mobilelife.api.beans.AuthResponse;
//import com.mobilelife.api.beans.ErrorReposne;
import com.mobilelife.common.GeekCodes;
import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.UserAccessEntity;
import com.mobilelife.persistance.entities.UserAccessTokenEntity;

public class AuthenticationPojo {
	private static Logger logger = LoggerFactory.getLogger(AuthenticationPojo.class);

//    public String getAuthenticate(String username, String password, String affId, String hashcode) throws Exception {
//    	String retToken = null;
//    	boolean isValid = false;
//    	UserAccess userAccess =  null;
//        Session session = HibernateSessionManager.getSession();
//        String compairStringHash = username+"|"+password+"|"+affId;
////		GeekCodes gc = new GeekCodes();
////		String password = gc.getMd5(passwordx);
//        String access_key = "";
//        String access_salt = "";
//        try
//        {
//	        String query = "Select * from user_access where userName ='"+username+"' and app_id ='"+affId+"' and password ='"+password+"' and online = 0 ";
//	        logger.debug("query in authenticate "+query);
//	        List<UserAccess> db_UserAccessList = null;
//	        db_UserAccessList = new HibernateDAO().findBySQLQuery(session, UserAccess.class, query, "user_access");
//	       
//	        if ((null != db_UserAccessList) && (db_UserAccessList.size() > 0)) {
//	        	for (int i = 0; i < db_UserAccessList.size(); i++) {
//	        		userAccess =  db_UserAccessList.get(i);
//		        	access_key = userAccess.getAccessKey();
//		        	access_salt = userAccess.getAccessSalt();
//	        		System.out.println("getUserName   "+userAccess.getUserName());
//	        		isValid = true;
//	        	}
//	        }
//	        if (isValid)
//	        {
//	        	GeekCodes geekCode = new GeekCodes();
//	        	String userHashcode = geekCode.decrypt(access_key, access_salt, hashcode);
//	        	if ((null!=userHashcode) && (userHashcode.equalsIgnoreCase(compairStringHash)))
//	        		retToken = issueToken(userAccess);
//	        	else
//	        		retToken = null;
//	        }
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		finally
//		{
//			session.flush();
//			session.clear();
//			session.close();
//			// HibernateSessionManager.closeSession()();
//		}
//    	
//    	return retToken;
//    }
//
//    public AuthResponse authenticate(AuthRequest credential)
//    {
//    	AuthResponse authResp = new AuthResponse();
//    	String authResToken;
//    	String username = credential.getUsername();
//    	String password = credential.getPassword();
//    	String affId = credential.getAppID();
//    	String hashcode = credential.getHashCode();
//		try {
//			authResToken = getAuthenticate(username,  password,  affId, hashcode);
//	    	if (null!=authResToken)
//	    	{
//	        	authResp.setAuthtoken(authResToken);
//	    	}
//	    	else
//	    	{
//	    		ErrorReposne errorReposne = new ErrorReposne();
//	    		errorReposne.setCode("403");
//	    		errorReposne.setDesc("Forbidden");
//	    		authResp.setError(errorReposne);
//	        	authResp.setAuthtoken("0");;
//	    	}
//		} catch (Exception e) {
//    		ErrorReposne errorReposne = new ErrorReposne();
//    		errorReposne.setCode("403");
//    		errorReposne.setDesc("Forbidden");
//    		authResp.setError(errorReposne);
//        	authResp.setAuthtoken("0");;
//			e.printStackTrace();
//		}
//    	return authResp;
//    }
//
//    public String issueToken(UserAccess db_UserAccess) {
//    	String retToken  = createNewToken(db_UserAccess);
//        return retToken;
//    }
//
//	public boolean checkValidToken(String tokenId, String affId) {
//		boolean isValidToken = false;
//		try {
//			UserAccessToken db_UserAccessToken = checkToken(tokenId, affId);
//			if (null!= db_UserAccessToken)
//			{
//		    	Calendar now = Calendar.getInstance();
//		    	if (Long.parseLong(db_UserAccessToken.getTokenValidity()) >= now.getTimeInMillis())
//		    	{
//		    		isValidToken = true;
//		    	}
//		    	else
//		    	{
//		    		isValidToken = false;
//		    	}
//			}
//			else
//			{
//	    		isValidToken = false;
//			}
//		} catch (Exception e) {
//    		isValidToken = false;
//			e.printStackTrace();
//		}
//    	return isValidToken;	
//    }
//
//	private String createNewToken( UserAccess db_UserAccess) {
//    	
//    	Calendar now = Calendar.getInstance();
//    	long retToken =now.getTimeInMillis();
//    	now.add(Calendar.MINUTE, 120);
//    	long validitytime = now.getTimeInMillis();
//        Session session = HibernateSessionManager.getSession();
//        Transaction  tx = session.beginTransaction();
//        try
//        {
//	        UserAccessToken db_UserAccessToken = new UserAccessToken();
//	        db_UserAccessToken.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
//	        db_UserAccessToken.setAccessToken(retToken+"");
//	        db_UserAccessToken.setAppId(db_UserAccess.getAppId());
//	        db_UserAccessToken.setRid(db_UserAccess.getRid());
//	        db_UserAccessToken.setOnline(0);
//	        db_UserAccessToken.setTokenValidity(validitytime+"");
//	        session.save(db_UserAccessToken);
//	        tx.commit();
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//			tx.rollback();
//		}
//		finally
//		{
//			session.flush();
//			session.clear();
//			session.close();
//			// HibernateSessionManager.closeSession()();
//		}
//        
//    	return retToken+"";
//	}
//
//	private UserAccessToken checkToken(String tokenId, String affId) {
//        Session session = HibernateSessionManager.getSession();
//        UserAccessToken db_UserAccessToken = null;
//        try
//        {
//	        String query = "Select * from user_access_token where online=0 and app_id ='"+affId+"' and access_token ='"+tokenId+"'";
//	        if (null==affId)
//	        	query = "Select * from user_access_token where online=0 and access_token ='"+tokenId+"'";
//	        logger.debug("query in checkToken "+query);
//	        List<UserAccessToken> db_UserAccessTokenList = null;
//	        db_UserAccessTokenList = new HibernateDAO().findBySQLQuery(session, UserAccessToken.class, query, "user_access_token");
//	       
//	        if ((null != db_UserAccessTokenList) && (db_UserAccessTokenList.size() > 0)) {
//	        	for (int i = 0; i < db_UserAccessTokenList.size(); i++) {
//	        		db_UserAccessToken = db_UserAccessTokenList.get(i);
//	        	}
//	        }
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		finally
//		{
//			session.flush();
//			session.clear();
//			session.close();
//			// HibernateSessionManager.closeSession()();
//		}
//
//    	return db_UserAccessToken;
//	} 
//	
//	public String generatePasswordString(String input)
//	{
//		String hashtext =  null;
//		try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            byte[] messageDigest = md.digest(input.getBytes());
//            BigInteger number = new BigInteger(1, messageDigest);
//            hashtext = number.toString(16);
//            System.out.println("1"+ hashtext);
//            // Now we need to zero pad it if you actually want the full 32 chars.
//            while (hashtext.length() < 32) {
//                hashtext = "0" + hashtext;
//            }
//            System.out.println("2" + hashtext);
//            return hashtext;
//        }
//        catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//	}
//	
//	public static void main(String[] arg)
//	{
//    	AuthenticationPojo authPojo = new AuthenticationPojo();
//    	String username, password, affId ="";
//    	username = "Deepak";
//    	password = "Deepak";
//    	affId = "TEST";
////    	AuthResponse authResponse = authPojo.authenticate(username, password, affId);
////    	System.out.println(authResponse.getStatus());
////    	System.out.println(authResponse.getTokenID());
//    	authPojo.generatePasswordString(password);
//	}
}
