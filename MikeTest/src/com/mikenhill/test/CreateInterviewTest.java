package com.mikenhill.test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CreateInterviewTest {

	int uniqueId = 1;
	String createInterviewInterviewId = null;
	String createInterviewInterviewToken = null;
	String submitPageTemplate = "<submitPage xmlns:xsi=\"xsi\" xmlns=\"http://service.underwriting.webservice.liss.co.uk\"><submitPageRequest><auditData xmlns=\"http://request.core.webservice.liss.co.uk/xsd\"><ghostUserId xsi:nil=\"true\" xmlns=\"http://domain.core.webservice.liss.co.uk/xsd\"/><pageCode xmlns=\"http://domain.core.webservice.liss.co.uk/xsd\">service</pageCode><userId xsi:nil=\"true\" xmlns=\"http://domain.core.webservice.liss.co.uk/xsd\"/></auditData><interviewToken xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\">m3CVzfN6LuzIzgb7R55b</interviewToken><interviewId xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\">8217</interviewId><lifeNumber xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\">1</lifeNumber><pageNumber xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\">26</pageNumber><questions xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\"><answers xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\"><value>#ANSWER#</value></answers><code xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\">#QUESTION_CODE#</code></questions></submitPageRequest></submitPage>";
	private String server_dns;
	private String externalToken;
	private String SG_FACADE_ENDPOINT;
	private String rulebookNb;
	private String rulebookUw;
	

		
	
	public static void main (String args[] ) {
		CreateInterviewTest cit = new CreateInterviewTest();
		cit.createInterview();
	}
	
	private void createInterview() {
	
		String XML_TEMPLATE = "<createInterview xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://service.underwriting.webservice.liss.co.uk\">"
				+ "<createInterviewRequest>"
				+ "<auditData xmlns=\"http://request.core.webservice.liss.co.uk/xsd\">"
				+ "<ghostUserId xmlns=\"http://domain.core.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/>"
				+ "<pageCode xmlns=\"http://domain.core.webservice.liss.co.uk/xsd\">service</pageCode>"
				+ "<userId xmlns=\"http://domain.core.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/>"
				+ "</auditData>"
				+ "<interviewScores xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\">"
				+ "<initialValue xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/>"
				+ "<scoreCategory xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/>"
				+ "<scoreDescription xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/>"
				+ "<scoreGroupName xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\">EXTERNAL_TOKEN</scoreGroupName>"
				+ "<value xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\">#EXTERNAL_TOKEN#</value>"
				+ "</interviewScores><interviewScores xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\">"
				+ "<initialValue xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/>"
				+ "<scoreCategory xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/>"
				+ "<scoreDescription xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/>"
				+ "<scoreGroupName xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\">SG_INDEM_ALLOWED</scoreGroupName><value xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\">Y</value></interviewScores><lives xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\"><clientId xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\">1</clientId></lives><reference xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/><rulebookName xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\">#RULEBOOK_NB#</rulebookName><windToPageCode xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/><interviewScores xmlns=\"http://request.underwriting.webservice.liss.co.uk/xsd\"><initialValue xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/><scoreCategory xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/><scoreDescription xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\" xsi:nil=\"true\"/><scoreGroupName xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\">UW_RULEBOOK_NAME</scoreGroupName><value xmlns=\"http://domain.underwriting.webservice.liss.co.uk/xsd\">#RULEBOOK_UW#</value></interviewScores></createInterviewRequest></createInterview>";
		
		String dataToSend = XML_TEMPLATE.replace("#EXTERNAL_TOKEN#", externalToken)
										.replace("#RULEBOOK_NB#", rulebookNb)
										.replace("#RULEBOOK_UW#", rulebookUw);

		String serviceNamespace = "http://service.underwriting.webservice.liss.co.uk";
		String portNamespace = "http://service.underwriting.webservice.liss.co.uk";
		String portLocalName = "UnderwritingServiceSoap11Binding";
		String endpointAddress = "https://"+server_dns+":8543/ulissia-webservices/services/UnderwritingService.UnderwritingServiceHttpsSoap11Endpoint/";
		String serviceLocalName = "createInterview";
		String soapAction = "http://service.underwriting.webservice.liss.co.uk/createInterview";

		String response = HttpHelper.sendSoapRequest(dataToSend, serviceNamespace, serviceLocalName, portNamespace,
				portLocalName, endpointAddress, soapAction, new HashMap<String, String>(),
				SOAPBinding.SOAP11HTTP_BINDING);
		
		createInterviewInterviewId = getInterviewId(response);
		createInterviewInterviewToken = getInterviewToken(response);
		
		return response;
	}
	
	
}
