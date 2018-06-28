package client_method;

import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class query {
	public String query(String USER_TOKEN) throws ServiceException, RemoteException{
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"  
	             + "<SERVICE>"  
	             + "<HEADER>"  
	             + "<USER_TOKEN>"+USER_TOKEN+"</USER_TOKEN>"
	             + "</HEADER>"
	             + "<QUERY>"
	             + "<COMP_NAME></COMP_NAME>"
	             + "<APPROVAL_NUM></APPROVAL_NUM>"
	             + "<DISTRICT_CODE>230100</DISTRICT_CODE>"
	             + "<APPLY_START_DATE></APPLY_START_DATE>"
	             + "<APPLY_END_DATE></APPLY_END_DATE>"
	             + "<DAY></DAY>"
	             + "</QUERY>"
	             + "</SERVICE>";  
			
		System.out.println(xmlStr);  
		 Service service = new Service();  
	      Call call = (Call) service.createCall();  
	      call.setTargetEndpointAddress("http://192.168.59.1:8080/webservice/services/FacadeServicePort?wsdl");  
	      QName qName = new QName("http://webservice.ccnt.cn", "queryMain");  
	      call.setOperationName(qName);  
	      call.setUseSOAPAction(true);  
	      
	      //这下面两行一定要加上，否则接收在服务器端收不到。  
	      call.addParameter("xmlFile", XMLType.XSD_STRING, ParameterMode.IN);  
	      call.setReturnType(XMLType.XSD_STRING);  
	      String result = (String) call.invoke(new String[] {xmlStr});  
	      //System.out.println(result);  
	      return result;
		}
		
}
