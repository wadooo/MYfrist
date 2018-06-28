package util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

//import net.sf.json.JSON;
//import net.sf.json.xml.XMLSerializer;

public class UserToken {
	public String dom4j(String xml) throws DocumentException{
		//Map map = new HashMap();  
		Document   document = DocumentHelper.parseText(xml);  
	    Element root = document.getRootElement();  
	    Element HEADER = root.element("HEADER");
	    Element USER_TOKEN = HEADER.element("USER_TOKEN");
        String USER_TOKEN_String = USER_TOKEN.getText();
               
        return USER_TOKEN_String;
 }  

	}

