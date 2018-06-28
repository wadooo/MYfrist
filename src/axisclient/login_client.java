package axisclient;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.dom4j.DocumentException;

import client_method.login;
import client_method.query;
import util.Query_Map;
import util.UserToken;

public class login_client {

	public static void main(String[] args) throws RemoteException, ServiceException, DocumentException {
		login login = new login();
		String usertoken = login.login();
		UserToken dom = new UserToken();
		String USER_TOKEN = dom.dom4j(usertoken);
		System.out.println("USER_TOKEN:"+USER_TOKEN);
		query query = new query();
		String queryString = query.query(USER_TOKEN);
		Query_Map querymap = new Query_Map();
		System.out.println(queryString);
	}

}

