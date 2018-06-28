package test;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class testlogin {
	public String testlogin(){
		String url="http://192.168.1.124:8081/TaijiWebService.asmx?wsdl";
        Service service = new Service();
        Call call ;
    	 String o = null;
        //String xml = "111";
        try {
            call = (Call)service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName("http://tempuri.org/", "login"));
            call.addParameter(new QName("http://tempuri.org/","XMLFile"), XMLType.SOAP_STRING, ParameterMode.IN);  
            call.setReturnType(XMLType.SOAP_STRING);  // 设置调用方法的返回值类型 
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://tempuri.org/login");
            String xml = "<SERVICE><HEADER><USER_ID>S23010000100034001</USER_ID><PASSWORD>Password001</PASSWORD></HEADER></SERVICE>";
            String obj =(String)call.invoke(new String[]{xml});
            System.out.println(obj);
            
    		Document   document = DocumentHelper.parseText(obj);  
    	    Element root = document.getRootElement();  
    	    Element HEADER = root.element("HEADER");
    	    Element USER_TOKEN = HEADER.element("USER_TOKEN");
            String USER_TOKEN_String = USER_TOKEN.getText();
            o = USER_TOKEN_String;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return o;
	}
}
