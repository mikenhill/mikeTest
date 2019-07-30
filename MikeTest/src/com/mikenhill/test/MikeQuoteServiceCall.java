package com.mikenhill.test;

import java.util.HashMap;
import java.util.Map;

import uk.co.liss.base.utils.HttpHelper;

public class MikeQuoteServiceCall {
	public static void main(String[] args) {
				
		String serviceNamespace = "http://tempuri.org/Wssquote/";  //this is taken from SOAPUI imported WSDL soapenv:Envelope line
		String portNamespace = "http://tempuri.org/Wssquote/"; // same as above
		String portLocalName = "WSSQUOTE"; // <wsdl:portType name="WSSQUOTE">
		String endpointAddress = "http://localhost:8181/XWSQUOTE/WSSQUOTE"; //<soap:address location="http://localhost:8181/XWSQUOTE/WSSQUOTE"/>
		String serviceLocalName = "Wssquotecall"; // <wsdl:operation name="Wssquotecall">
		String soapAction = "http://tempuri.org/Wssquotecall/"; // <soap:operation soapAction="http://tempuri.org/Wssquotecall/"

		String dataToSend = getPayLoad();
		
		Map<String, String> paramMap = new HashMap<String, String> ();
		
		String result = HttpHelper.sendSoapRequest(dataToSend, serviceNamespace, serviceLocalName, 
				portNamespace, portLocalName, endpointAddress, soapAction, paramMap);
		
		System.out.println(result);

	}
	
	public static String getPayLoad() {
		return 
				"<wss:Wssquotecall xmlns:wss=\"http://tempuri.org/Wssquote/\"><WssquoteImport command=\"\" clientId=\"\" clientPassword=\"\" nextLocation=\"\" exitState=\"\" dialect=\"\">       "
				+ "            <!--Optional:-->                                                                                                 "
				+ "            <ImpAswcalcqAswcalcq>                                                                                            "
				+ "               <Comcalclvl/>                                                                                                 "
				+ "               <Pcdate/>                                                                                                     "
				+ "               <Srvtimings/>                                                                                                 "
				+ "            </ImpAswcalcqAswcalcq>                                                                                           "
				+ "            <!--Optional:-->                                                                                                 "
				+ "            <ImpUserUsers>                                                                                                   "
				+ "               <UsrId/>                                                                                                      "
				+ "            </ImpUserUsers>                                                                                                  "
				+ "            <!--Optional:-->                                                                                                 "
				+ "            <ImpWebserviceWebService>                                                                                        "
				+ "               <ServiceUserid/>                                                                                              "
				+ "               <TraceRates/>                                                                                                 "
				+ "               <RecordImport/>                                                                                               "
				+ "               <Requote/>                                                                                                    "
				+ "               <DiscountActivity/>                                                                                           "
				+ "               <QuoteCallOrigin/>                                                                                            "
				+ "            </ImpWebserviceWebService>                                                                                       "
				+ "            <!--Optional:-->                                                                                                 "
				+ "            <ImpGrpCvgs>                                                                                                     "
				+ "               <!--Zero or more repetitions:-->                                                                              "
				+ "               <row>                                                                                                         "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmQInstructionQuotation>                                                                              "
				+ "                     <QuoteInstruction/>                                                                                     "
				+ "                  </ImpItmQInstructionQuotation>                                                                             "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmOverridePolicyCoverages>                                                                            "
				+ "                     <SumAssured/>                                                                                           "
				+ "                  </ImpItmOverridePolicyCoverages>                                                                           "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmTargetPremiumCvgsPolicyPremiums>                                                                    "
				+ "                     <ModalPremium/>                                                                                         "
				+ "                     <Frequency/>                                                                                            "
				+ "                  </ImpItmTargetPremiumCvgsPolicyPremiums>                                                                   "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmCvgQrefWebService>                                                                                  "
				+ "                     <QuoteRef/>                                                                                             "
				+ "                     <BenLine>1</BenLine>                                                                                    "
				+ "                     <Primaryprdid/>                                                                                         "
				+ "                     <DiscountActivity/>                                                                                     "
				+ "                  </ImpItmCvgQrefWebService>                                                                                 "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPcpCvgsPolicyPremiums>                                                                              "
				+ "                     <Frequency>5</Frequency>                                                                                "
				+ "                     <ContributionPercentage/>                                                                               "
				+ "                     <ModalPremium/>                                                                                         "
				+ "                  </ImpItmPcpCvgsPolicyPremiums>                                                                             "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPocCvgsPolicyCoverages>                                                                             "
				+ "                     <ProductLine>TLL</ProductLine>                                                                          "
				+ "                     <Currency>GBP</Currency>                                                                                "
				+ "                     <InitialSumAssured>120000</InitialSumAssured>                                                           "
				+ "                     <SoldBasis>0</SoldBasis>                                                                                "
				+ "                     <Multiplier/>                                                                                           "
				+ "                     <CoverLevel/>                                                                                           "
				+ "                     <LivesType>7</LivesType>                                                                                "
				+ "                     <HoldingNo/>                                                                                            "
				+ "                     <Term>20</Term>                                                                                         "
				+ "                     <RetirementAge/>                                                                                        "
				+ "                     <TermAge/>                                                                                              "
				+ "                     <DateOfApplication/>                                                                                    "
				+ "                     <DateOfReqCommencement/>                                                                                "
				+ "                     <PptAge/>                                                                                               "
				+ "                     <InterestRate/>                                                                                         "
				+ "                     <PttYrs/>                                                                                               "
				+ "                     <DatePremiumTerm/>                                                                                      "
				+ "                     <BenefitBasis/>                                                                                         "
				+ "                     <QuotationDate>20160902</QuotationDate>                                                                 "
				+ "                     <QuotationTime/>                                                                                        "
				+ "                     <MajorCoverage/>                                                                                        "
				+ "                     <Income/>                                                                                               "
				+ "                     <ProductVersion/>                                                                                       "
				+ "                     <QuoteAgeDate>20160902</QuoteAgeDate>                                                                   "
				+ "                  </ImpItmPocCvgsPolicyCoverages>                                                                            "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPocPcmPolicyCommissions>                                                                            "
				+ "                     <Style>INDEM</Style>                                                                                    "
				+ "                     <IndemnificationPercent/>                                                                               "
				+ "                  </ImpItmPocPcmPolicyCommissions>                                                                           "
				+ "               </row>                                                                                                        "
				+ "            </ImpGrpCvgs>                                                                                                    "
				+ "            <!--Optional:-->                                                                                                 "
				+ "            <ImpGrpCliCpr>                                                                                                   "
				+ "               <!--Zero or more repetitions:-->                                                                              "
				+ "               <row>                                                                                                         "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmCliContactClientContactDetails>                                                                     "
				+ "                     <Postcode></Postcode>                                                                                   "
				+ "                  </ImpItmCliContactClientContactDetails>                                                                    "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmCliMxCeaseAgeProductValueLookup>                                                                    "
				+ "                     <Age1/>                                                                                                 "
				+ "                  </ImpItmCliMxCeaseAgeProductValueLookup>                                                                   "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmCprQrefWebService>                                                                                  "
				+ "                     <QuoteRef/>                                                                                             "
				+ "                     <BenLine>1</BenLine>                                                                                    "
				+ "                     <Primaryprdid/>                                                                                         "
				+ "                  </ImpItmCprQrefWebService>                                                                                 "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmCliAgeProductValueLookup>                                                                           "
				+ "                     <Age1/>                                                                                                 "
				+ "                     <Age1Months/>                                                                                           "
				+ "                     <ExpAge1/>                                                                                              "
				+ "                  </ImpItmCliAgeProductValueLookup>                                                                          "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPclLoadingsPolicyCvgLives>                                                                          "
				+ "                     <AgeRating/>                                                                                            "
				+ "                     <AddnFactor/>                                                                                           "
				+ "                     <AddnRpm/>                                                                                              "
				+ "                     <RatingReason/>                                                                                         "
				+ "                     <RatingTerm/>                                                                                           "
				+ "                     <UnderwriterRiskCategory/>                                                                              "
				+ "                  </ImpItmPclLoadingsPolicyCvgLives>                                                                         "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmCprPrlProductLines>                                                                                 "
				+ "                     <PrlId>TLL</PrlId>                                                                                      "
				+ "                  </ImpItmCprPrlProductLines>                                                                                "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmCprTypeCliPolRelationships>                                                                         "
				+ "                     <TypeNumber/>                                                                                           "
				+ "                     <Type>4</Type>                                                                                          "
				+ "                  </ImpItmCprTypeCliPolRelationships>                                                                        "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmCliClients>                                                                                         "
				+ "                     <DateOfBirth>19710101</DateOfBirth>                                                                     "
				+ "                     <Sex>2</Sex>                                                                                            "
				+ "                     <Smoker>2</Smoker>                                                                                      "
				+ "                     <RiskCat/>                                                                                              "
				+ "                     <Weight/>                                                                                               "
				+ "                     <Height/>                                                                                               "
				+ "                     <Nationality/>                                                                                          "
				+ "                     <Type/>                                                                                                 "
				+ "                     <LeisureRiskCat/>                                                                                       "
				+ "                     <Classification/>                                                                                       "
				+ "                     <CliId/>                                                                                                "
				+ "                     <Salary/>                                                                                               "
				+ "                     <SalaryCurrency/>                                                                                       "
				+ "                     <Bmi></Bmi>                                                                                             "
				+ "                     <WaistSize></WaistSize>                                                                                 "
				+ "                  </ImpItmCliClients>                                                                                        "
				+ "               </row>                                                                                                        "
				+ "            </ImpGrpCliCpr>                                                                                                  "
				+ "            <!--Optional:-->                                                                                                 "
				+ "            <ImpGrpPas>                                                                                                      "
				+ "               <!--Zero or more repetitions:-->                                                                              "
				+ "               <row>                                                                                                         "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPasQrefWebService>                                                                                  "
				+ "                     <QuoteRef/>                                                                                             "
				+ "                     <BenLine>1</BenLine>                                                                                    "
				+ "                     <Primaryprdid/>                                                                                         "
				+ "                  </ImpItmPasQrefWebService>                                                                                 "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPasPrlProductLines>                                                                                 "
				+ "                     <PrlId>TLL</PrlId>                                                                                      "
				+ "                  </ImpItmPasPrlProductLines>                                                                                "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPasPolicyAgentShares>                                                                               "
				+ "                     <Status/>                                                                                               "
				+ "                     <Coverage/>                                                                                             "
				+ "                     <Agent>A00003</Agent>                                                                                   "
				+ "                     <PasId/>                                                                                                "
				+ "                     <Percentage>100</Percentage>                                                                            "
				+ "                     <Type/>                                                                                                 "
				+ "                     <SpecificIce/>                                                                                          "
				+ "                     <SacrificeAmount/>                                                                                      "
				+ "                     <SacrificePercent/>                                                                                     "
				+ "                     <PrimaryAgent/>                                                                                         "
				+ "                     <SacrificeType/>                                                                                        "
				+ "                     <RenewalSacrificePcg/>                                                                                  "
				+ "                  </ImpItmPasPolicyAgentShares>                                                                              "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmAgtAgents>                                                                                          "
				+ "                     <AgtId>A00003</AgtId>                                                                                   "
				+ "                  </ImpItmAgtAgents>                                                                                         "
				+ "               </row>                                                                                                        "
				+ "            </ImpGrpPas>                                                                                                     "
				+ "            <!--Optional:-->                                                                                                 "
				+ "            <ImpGrpPlc>                                                                                                      "
				+ "               <!--Zero or more repetitions:-->                                                                              "
				+ "               <row>                                                                                                         "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPlcPolicyCvgLifeConditions>                                                                         "
				+ "                     <Condition/>                                                                                            "
				+ "                     <ApplicabilityDate/>                                                                                    "
				+ "                     <EndOfApplicability/>                                                                                   "
				+ "                     <RateOrValue/>                                                                                          "
				+ "                     <Type/>                                                                                                 "
				+ "                  </ImpItmPlcPolicyCvgLifeConditions>                                                                        "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPlcCprtypeCliPolRelationships>                                                                      "
				+ "                     <Type/>                                                                                                 "
				+ "                  </ImpItmPlcCprtypeCliPolRelationships>                                                                     "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPlcPrlProductLines>                                                                                 "
				+ "                     <PrlId/>                                                                                                "
				+ "                  </ImpItmPlcPrlProductLines>                                                                                "
				+ "                  <!--Optional:-->                                                                                           "
				+ "                  <ImpItmPlcQrefWebService>                                                                                  "
				+ "                     <BenLine/>                                                                                              "
				+ "                     <QuoteRef/>                                                                                             "
				+ "                     <Primaryprdid/>                                                                                         "
				+ "                  </ImpItmPlcQrefWebService>                                                                                 "
				+ "               </row>                                                                                                        "
				+ "            </ImpGrpPlc>                                                                                                     "
				+ "            <!--Optional:-->                                                                                                 "
				+ "            <ImpPrlrqmWebService>                                                                                            "
				+ "               <Prlrqm/>                                                                                                     "
				+ "            </ImpPrlrqmWebService>                                                                                           "
				+ "         </WssquoteImport>                                                                                                   "
				+ "      </wss:Wssquotecall>                                                                                                    ";
	}
}
