package client_method;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class login {
	public String login() throws ServiceException, RemoteException{
	String USER_ID = "S23010000100034001";
	String PASSWORD = "Password001";
	String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"  
             + "     <SERVICE>"  
             + "        <HEADER>"  
             + "            <USER_ID>"+USER_ID+"</USER_ID>"  
             + "            <PASSWORD>"+PASSWORD+"</PASSWORD>"  
             + "        </HEADER>"  
             + "     </SERVICE>";  
	
	 Service service = new Service();  
      Call call = (Call) service.createCall();  
      call.setTargetEndpointAddress("http://192.168.59.1:8080/webservice/services/zhiFaInfoService?wsdl");  
      QName qName = new QName("http://webservice.ccnt.cn", "login");  
      call.setOperationName(qName);  
      call.setUseSOAPAction(true);  
      
      //这下面两行一定要加上，否则接收在服务器端收不到。  
      call.addParameter("XMLFile", XMLType.XSD_STRING, ParameterMode.IN);  
      call.setReturnType(XMLType.XSD_STRING);  
      String result = (String) call.invoke(new String[] { xmlStr });  
      //System.out.println(result);  
	return result;
	}
}
