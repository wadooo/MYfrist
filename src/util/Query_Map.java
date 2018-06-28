package util;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import client_method.query;
import test.testClient;
import test.testlogin;
import dao.body;


public class Query_Map {
	public static List<body> body = null;
   public List<body> QueryMap(String xml) throws DocumentException{
	   List<body> body = new ArrayList<body>();
	   body.clear();
	   Document doc = DocumentHelper.parseText(xml);
	   
	   Element root = doc.getRootElement();
	   //List list = root.elements();
       for(Iterator itrecord=root.elementIterator();itrecord.hasNext();){
    	   body bod = new body();
           Element record = (Element) itrecord.next();
           
           bod.setCOMP_CODE(record.elementText("COMP_CODE"));
           bod.setCOMP_NAME(record.elementText("COMP_NAME"));
           bod.setBUSINESS_ID(record.elementText("BUSINESS_ID"));
           bod.setORGANIZE_TYPE(record.elementText("ORGANIZE_TYPE"));
           bod.setCAPITAL_TYPE(record.elementText("CAPITAL_TYPE"));
           bod.setREG_ADDRESS(record.elementText("REG_ADDRESS"));
           bod.setREG_ADDRESS_DETAIL(record.elementText("REG_ADDRESS_DETAIL"));
           bod.setDISTRICT_CODE(record.elementText("DISTRICT_CODE"));
           bod.setCOMP_CREDENTIALS_TYPE(record.elementText("COMP_CREDENTIALS_TYPE"));
           bod.setCOMP_CREDENTIALS_CODE(record.elementText("COMP_CREDENTIALS_CODE"));
           bod.setCREDENTIALS_VALIDITY_START(record.elementText("CREDENTIALS_VALIDITY_START"));
           bod.setCREDENTIALS_VALIDITY_END(record.elementText("CREDENTIALS_VALIDITY_END"));
           bod.setORGANIZE_CODE(record.elementText("ORGANIZE_CODE"));
           bod.setREG_FUND(record.elementText("REG_FUND"));
           bod.setFUND_BZ(record.elementText("FUND_BZ"));
           bod.setPOST_CODE(record.elementText("POST_CODE"));
           bod.setCOMP_EMAIL(record.elementText("COMP_EMAIL"));
           bod.setCOMP_TEL(record.elementText("COMP_TEL"));
           bod.setCOMP_FAX(record.elementText("COMP_FAX"));
           bod.setBUSI_AREA(record.elementText("BUSI_AREA"));
           bod.setEMP_NUMBER(record.elementText("EMP_NUMBER"));
           bod.setLEGAL_NAME(record.elementText("LEGAL_NAME"));
           bod.setLEGAL_SEX(record.elementText("LEGAL_SEX"));
           bod.setLEGAL_CREDENTIALS_TYPE(record.elementText("LEGAL_CREDENTIALS_TYPE"));
           bod.setLEGAL_CREDENTIALS_CODE(record.elementText("LEGAL_CREDENTIALS_CODE"));
           bod.setLEGAL_TEL(record.elementText("LEGAL_TEL"));
           bod.setLEGAL_MOBILE(record.elementText("LEGAL_MOBILE"));
           bod.setLEGAL_EDUCATION(record.elementText("LEGAL_EDUCATION"));
           bod.setACTOR_NUM(record.elementText("ACTOR_NUM"));
           bod.setAGENT_NUM(record.elementText("AGENT_NUM"));
           bod.setIS_BELONG_PUBLIC(record.elementText("IS_BELONG_PUBLIC"));
           bod.setCHECK_PEOPLE_NUM(record.elementText("CHECK_PEOPLE_NUM"));
           bod.setROOM_NUM(record.elementText("ROOM_NUM"));
           bod.setCHECK_MACHINE_NUM(record.elementText("CHECK_MACHINE_NUM"));
           bod.setIP_ADDRESS(record.elementText("IP_ADDRESS"));
           bod.setPLAN_FUNDS(record.elementText("PLAN_FUNDS"));
           bod.setPLAN_NUM(record.elementText("PLAN_NUM"));
           bod.setHEAD_COM(record.elementText("HEAD_COM"));
           bod.setHEAD_LICENCE(record.elementText("HEAD_LICENCE"));
           bod.setBAR_NUM(record.elementText("BAR_NUM"));
           bod.setSERVER_NUM(record.elementText("SERVER_NUM"));
           bod.setFUN_NUM(record.elementText("FUN_NUM"));
           bod.setUP_COMP_NAME(record.elementText("UP_COMP_NAME"));
           bod.setSERVER_CONTENT(record.elementText("SERVER_CONTENT"));
           bod.setAPPLY_DATE(record.elementText("APPLY_DATE"));
           bod.setAPPROVAL_DATE(record.elementText("APPROVAL_DATE"));
           bod.setAPPROVAL_CODE(record.elementText("APPROVAL_CODE"));
           bod.setAPPROVAL_NAME(record.elementText("APPROVAL_NAME"));
           bod.setAPPROVAL_NUM(record.elementText("APPROVAL_NUM"));        
           
           body.add(bod);
           
       }
	   
	   return body;
   }
//   public static void main(String [] args) throws RemoteException, MalformedURLException, ServiceException, DocumentException{
//	   testlogin tl = new testlogin();
//		testClient tc = new testClient();
//		Query_Map querymap = new Query_Map();
//		
//		String xml = tc.ClientString(tl.testlogin());
//		List<body> list = querymap.QueryMap(xml);
//	   
//	   
//	   System.out.println(list.size());
//       
//
//   } 
}
