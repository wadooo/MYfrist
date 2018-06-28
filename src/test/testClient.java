package test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class testClient {
	public String ClientString(String USER_TOKEN) throws RemoteException, ServiceException, MalformedURLException {
		String url="http://192.168.1.124:8081/TaijiWebService.asmx?wsdl";
        Service service = new Service();
        Call call ;
    	 String o = null;
        //String xml = "111";
        try {
            call = (Call)service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName("http://tempuri.org/", "queryMain"));
            call.addParameter(new QName("http://tempuri.org/","XMLFile"), XMLType.SOAP_STRING, ParameterMode.IN);  
            call.setReturnType(XMLType.SOAP_STRING);  // 设置调用方法的返回值类型 
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://tempuri.org/queryMain");
            String xml = "<SERVICE><HEADER><USER_TOKEN>"+USER_TOKEN+"</USER_TOKEN></HEADER><QUERY><DISTRICT_CODE>230102</DISTRICT_CODE></QUERY></SERVICE>";
            String obj =(String)call.invoke(new String[]{xml});
            o = obj;
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return o;
		}
	

	}

