package com.mikenhill.test.xpath;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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

public class XpathExamples {
	
	private static String xmlSource = "<QUOTE_DATA><DATA><PORTAL_SOURCE>No</PORTAL_SOURCE><PA_FORENAME>DSAAS</PA_FORENAME><PA_SURNAME>ASDA</PA_SURNAME><SA_SMOKER /><SA_POSTCODE /><TYPE>single</TYPE><COMMISSION_DATA><Details><INIT_COMMISSION>£114.13</INIT_COMMISSION><REN_PA_LIFE>£0.13</REN_PA_LIFE><REN_PA_CI>£0.00</REN_PA_CI><SWITCH>true</SWITCH></Details></COMMISSION_DATA><Lifecover><Details><Policyno>TL1003331</Policyno><Coverage>1</Coverage><Switch>Yes</Switch><SumAssured>100,000</SumAssured><Term>10</Term><Product_Name>Term Life</Product_Name><Date_Of_Termination>18/07/2029</Date_Of_Termination><Anniversary_Date>18 July</Anniversary_Date><Date_Of_Commencement>18/07/2019</Date_Of_Commencement><ProductLineName>Level Term Life</ProductLineName><ProductLineType>2</ProductLineType><policyType>7</policyType><Modalpremium>£5.13</Modalpremium><Covertype>Increasing</Covertype><Product>Life Protection</Product></Details></Lifecover><CIcover><Details><Policyno>CI1003184</Policyno><Coverage>1</Coverage><Switch>Yes</Switch><SumAssured>100,000</SumAssured><Term>10</Term><Product_Name>Critical Illness</Product_Name><Date_Of_Termination>18/07/2029</Date_Of_Termination><Anniversary_Date>18 July</Anniversary_Date><Date_Of_Commencement>18/07/2019</Date_Of_Commencement><ProductLineName>Critical Illness Level</ProductLineName><ProductLineType>9</ProductLineType><policyType>7</policyType><Modalpremium>£22.37</Modalpremium><Covertype>Increasing</Covertype><Product>Critical Illness</Product></Details></CIcover></DATA></QUOTE_DATA>";
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder;
	Document doc = null;

	public static void main (String args[]) {
		XpathExamples xpe = new XpathExamples();
		xpe.updateAllFoundNodes();
		
	}
	
	//
	//COPY the entire COMMISSION_DATA element set and put as child of TYPE AND PORTAL_SOURCE
	//Leaving it also whence it came
	//
	private String copyNodesToNewParent () {
		String convertedXml = null;
		
		try {
			builder = factory.newDocumentBuilder();
            XPathFactory xpathFactory = XPathFactory.newInstance();            
            XPath xpath = xpathFactory.newXPath();

            InputSource is = new InputSource(new StringReader(xmlSource));
            doc = builder.parse(is);
            
            XPathExpression expr = xpath.compile("/QUOTE_DATA/DATA/COMMISSION_DATA");
            Node nodeCommData = (Node)expr.evaluate(doc, XPathConstants.NODE);
            
            expr = xpath.compile("/QUOTE_DATA/DATA/TYPE");
            Node nodeType = (Node)expr.evaluate(doc, XPathConstants.NODE);
            
            expr = xpath.compile("/QUOTE_DATA/DATA/PORTAL_SOURCE");
            Node nodePortalSource = (Node)expr.evaluate(doc, XPathConstants.NODE);
            
            Node newCommData1 = doc.importNode(nodeCommData, true);
            Node newCommData2 = doc.importNode(nodeCommData, true);
            nodeType.appendChild(newCommData1);
            nodePortalSource.appendChild(newCommData2);
            
            convertedXml = printXmlDocument(doc);
	        System.out.println(convertedXml);
            
		} catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
		} catch (XPathExpressionException e) {
            e.printStackTrace();
        }          
		
		return convertedXml;
	}	
	
	//
	//Update ALL nodes with specifed name to supplied value
	//
	private String updateAllFoundNodes () {
		String convertedXml = null;
		
		String newValue = "new value";
		
		try {
			builder = factory.newDocumentBuilder();
            XPathFactory xpathFactory = XPathFactory.newInstance();            
            XPath xpath = xpathFactory.newXPath();

            InputSource is = new InputSource(new StringReader(xmlSource));
            doc = builder.parse(is);
            
            XPathExpression expr = xpath.compile(".//Anniversary_Date");
            NodeList nodes = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
            
            //NodeList nodes = node.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
            	nodes.item(i).setTextContent(newValue);
            }
            
            convertedXml = printXmlDocument(doc);
	        System.out.println(convertedXml);
            
		} catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
		} catch (XPathExpressionException e) {
            e.printStackTrace();
        }          
		
		return convertedXml;
	}
	
	//
	//Move the entire COMMISSION_DATA element set and put as child of TYPE
	//
	private String moveNodesToNewParent () {
		String convertedXml = null;
		
		try {
			builder = factory.newDocumentBuilder();
            XPathFactory xpathFactory = XPathFactory.newInstance();            
            XPath xpath = xpathFactory.newXPath();

            InputSource is = new InputSource(new StringReader(xmlSource));
            doc = builder.parse(is);
            
            XPathExpression expr = xpath.compile("/QUOTE_DATA/DATA/COMMISSION_DATA");
            Node nodeCommData = (Node)expr.evaluate(doc, XPathConstants.NODE);
            
            expr = xpath.compile("/QUOTE_DATA/DATA/TYPE");
            Node nodeType = (Node)expr.evaluate(doc, XPathConstants.NODE);
            
            nodeType.appendChild(nodeCommData);
            
            convertedXml = printXmlDocument(doc);
	        System.out.println(convertedXml);
            
		} catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
		} catch (XPathExpressionException e) {
            e.printStackTrace();
        }          
		
		return convertedXml;
	}
	
	//Adds a new node before <TYPE>single</TYPE> called <Newbie>text</Newbie>
	private String addNewChildNode () {
		String convertedXml = null;
		
		try {
			builder = factory.newDocumentBuilder();
            XPathFactory xpathFactory = XPathFactory.newInstance();            
            XPath xpath = xpathFactory.newXPath();

            InputSource is = new InputSource(new StringReader(xmlSource));
            doc = builder.parse(is);
            
            XPathExpression expr = xpath.compile("/QUOTE_DATA/DATA");
            Node node = (Node)expr.evaluate(doc, XPathConstants.NODE);
            NodeList nodes = node.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
            	Node nodeChild = nodes.item(i);
            	if (nodeChild.getNodeName().equals("TYPE")) {
            		Node newChild = doc.createElement("Newbie");
            		newChild.setTextContent("new text");
            		node.insertBefore(newChild, nodeChild);
            		break;
            	}
            }
            
            convertedXml = printXmlDocument(doc);
	        System.out.println(convertedXml);
            
		} catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
		} catch (XPathExpressionException e) {
            e.printStackTrace();
        }          
		
		return convertedXml;
	}
	
	//In the method below we will update <COMMISSION_DATA> to <COMMISSION_DATA_NEW>
	private String updateNameOfNode () {
		String convertedXml = null;
		
		
		try {
			builder = factory.newDocumentBuilder();
            XPathFactory xpathFactory = XPathFactory.newInstance();            
            XPath xpath = xpathFactory.newXPath();
            
            //File file = new File("C:\\temp\\xmlTestFiles\\createInterviewResponse.xml");
            //FileInputStream fis = new FileInputStream(file);

            InputSource is = new InputSource(new StringReader(xmlSource));
            doc = builder.parse(is);
            NodeList nodes = doc.getElementsByTagName("COMMISSION_DATA");
            
            for (int i = 0; i < nodes.getLength(); i++) {
            	Node node = nodes.item(i);
            	doc.renameNode(node, null, "COMMISSION_DATA_NEW");
            }
            convertedXml = printXmlDocument(doc);
	        System.out.println(convertedXml);
            
		} catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
		}         
		
		return convertedXml;
	}
	
	private String updateSingleTextValue () {
		String convertedXml = null;
		
		
		
		try {
			builder = factory.newDocumentBuilder();
            XPathFactory xpathFactory = XPathFactory.newInstance();            
            XPath xpath = xpathFactory.newXPath();
            
            //File file = new File("C:\\temp\\xmlTestFiles\\createInterviewResponse.xml");
            //FileInputStream fis = new FileInputStream(file);

            InputSource is = new InputSource(new StringReader(xmlSource));
            doc = builder.parse(is);
            
            xpath.setNamespaceContext(new UniversalNamespaceResolver(doc));
            
            //Update the text content of the <PA_SURNAME> node but only if it is set to ASDA
            XPathExpression expr = xpath.compile
            		("/QUOTE_DATA/DATA/PA_SURNAME/text()");
            
            Node paSurnameNode = (Node)expr.evaluate(doc, XPathConstants.NODE);
           		              
            if (paSurnameNode != null) {
            	String paSurname = paSurnameNode.getNodeValue();
            	if (paSurname != null && paSurname.equals("ASDA")) {
            		//Update the value to Smith
            		paSurnameNode.setNodeValue("Smith");
            		convertedXml = printXmlDocument(doc);
        	        System.out.println(convertedXml);
            		
            	}
            }
            
		} catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
		} catch (XPathExpressionException e) {
            e.printStackTrace();
        }         
		
		return convertedXml;
	}
	
	public static String printXmlDocument(Document document) {
		StringWriter sw = null;
		try {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		sw = new StringWriter();
		trans.transform(new DOMSource(document), new StreamResult(sw));
		} catch (Exception ex) {
			
		}
		return sw.toString();
	}
	
}
