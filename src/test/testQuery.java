package test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.dom4j.DocumentException;

import dao.body;
import util.Query_Map;

public class testQuery {
	public Map QueryMap(){
		return null;
	}

	public static void main(String[] args) throws RemoteException, ServiceException, MalformedURLException, DocumentException {
		testlogin tl = new testlogin();
		testClient tc = new testClient();
		Query_Map querymap = new Query_Map();
		
		String xml = tc.ClientString(tl.testlogin());
		List<body> main = querymap.QueryMap(xml);
		//String string = main.get(0).getCOMP_CODE();		
		System.out.println(main.get(0));
	}
}
