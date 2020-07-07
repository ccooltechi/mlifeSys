package com.mobilelife.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientInfo {

	private static Logger logger = LoggerFactory.getLogger(ClientInfo.class);

    public void printClientInfo(HttpServletRequest request) {
        final String referer = getReferer(request);
        final String fullURL = getFullURL(request);
        final String clientIpAddr = getClientIpAddr(request);
        final String clientOS = getClientOS(request);
        final String clientBrowser = getClientBrowser(request);
        final String userAgent = getUserAgent(request);
        
        logger.info("\n" +
                            "User Agent \t" + userAgent + "\n" +
                            "Operating System\t" + clientOS + "\n" +
                            "Browser Name\t" + clientBrowser + "\n" +
                            "IP Address\t" + clientIpAddr + "\n" +
                            "Full URL\t" + fullURL + "\n" +
                            "Referrer\t" + referer);
    }

    public String getReferer(HttpServletRequest request) {
        String referer = "";
        try {
        	if (null!=request)
        		referer = request.getHeader("referer");
        }catch (Exception ex) {}
        return referer;
    }

    public String getFullURL(HttpServletRequest request) {
        final StringBuffer requestURL = request.getRequestURL();
        final String queryString = request.getQueryString();

        final String result = queryString == null ? requestURL.toString() : requestURL.append('?')
                .append(queryString)
                .toString();

        return result;
    }

    //http://stackoverflow.com/a/18030465/1845894
    public String getClientIpAddr(HttpServletRequest request) {
        String ip = "";
        try {
	        ip = request.getHeader("X-Forwarded-For");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
        }catch (Exception ex) {}
        return ip;
    }

    //http://stackoverflow.com/a/18030465/1845894
    public String getClientOS(HttpServletRequest request) {
    	String browser = "";
    	try
    	{
	        String browserDetails = request.getHeader("User-Agent");
	
	        //=================OS=======================
	        final String lowerCaseBrowser = browserDetails.toLowerCase();
	        if (lowerCaseBrowser.contains("windows")) {
	        	browser =  "Windows";
	        } else if (lowerCaseBrowser.contains("mac")) {
	        	browser =  "Mac";
	        } else if (lowerCaseBrowser.contains("x11")) {
	        	browser =  "Unix";
	        } else if (lowerCaseBrowser.contains("android")) {
	        	browser =  "Android";
	        } else if (lowerCaseBrowser.contains("iphone")) {
	        	browser =  "IPhone";
	        } else {
	        	browser =  "UnKnown, More-Info: " + browserDetails;
	        }
    	}catch(Exception ex) {}
    	return browser;
    }

    //http://stackoverflow.com/a/18030465/1845894
    public String getClientBrowser(HttpServletRequest request) {
        String browser = "";
        try {
	        String browserDetails = request.getHeader("User-Agent");
	        String user = browserDetails.toLowerCase();
	
	
	        //===============Browser===========================
	        if (user.contains("msie")) {
	            String substring = browserDetails.substring(browserDetails.indexOf("MSIE")).split(";")[0];
	            browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
	        } else if (user.contains("safari") && user.contains("version")) {
	            browser = (browserDetails.substring(browserDetails.indexOf("Safari")).split(" ")[0]).split(
	                    "/")[0] + "-" + (browserDetails.substring(
	                    browserDetails.indexOf("Version")).split(" ")[0]).split("/")[1];
	        } else if (user.contains("opr") || user.contains("opera")) {
	            if (user.contains("opera"))
	                browser = (browserDetails.substring(browserDetails.indexOf("Opera")).split(" ")[0]).split(
	                        "/")[0] + "-" + (browserDetails.substring(
	                        browserDetails.indexOf("Version")).split(" ")[0]).split("/")[1];
	            else if (user.contains("opr"))
	                browser = ((browserDetails.substring(browserDetails.indexOf("OPR")).split(" ")[0]).replace("/",
	                                                                                                           "-")).replace(
	                        "OPR", "Opera");
	        } else if (user.contains("chrome")) {
	            browser = (browserDetails.substring(browserDetails.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
	        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1) || (user.indexOf(
	                "mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf(
	                "mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1)) {
	            //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
	            browser = "Netscape-?";
	
	        } else if (user.contains("firefox")) {
	            browser = (browserDetails.substring(browserDetails.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
	        } else if (user.contains("rv")) {
	            browser = "IE";
	        } else {
	            browser = "UnKnown, More-Info: " + browserDetails;
	        }
        }catch (Exception ex) {}
        return browser;
    }

    public String getUserAgent(HttpServletRequest request) {
    	String useragent ="";
    	try {
    		useragent = request.getHeader("User-Agent");
    	}catch (Exception ex) {}
        return useragent;
    }
}
