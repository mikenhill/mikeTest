package com.mikenhill.test;

import java.util.Collection;
import java.util.Iterator;

import javax.xml.bind.SchemaOutputResolver;

import uk.co.liss.origoutils.mapper.apply.OrigoToExtranetTransformer;
import uk.co.liss.underwriting.beans.interview.Interview;
import uk.co.liss.underwriting.beans.interview.Score;

public class OrigoTest {

	public static void main(String[] args) {
		OrigoTest ot = new OrigoTest();
		String ELINK_ORIGO_DATA = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><message><m_control><control_timestamp>2019-01-22T14:15:49</control_timestamp><message_id>c40d7785-5167-41ba-9ed6-a42f5f038611</message_id><retry_number>0</retry_number><message_type>Proposal</message_type><message_version>/origo/3.8/QNBProtectionNewBusiness.xsd</message_version><expected_response_type>extranet re-direct</expected_response_type><initiator_id>AssureWeb</initiator_id><initiator_orchestration_id>06d59911-56a7-43e6-bd60-0dd5b522ba3b</initiator_orchestration_id><user_id>mkholwadia</user_id><responder_id>gryphon</responder_id><browser><portal_user_name /><portal_password /><service_id>QuotetoApp</service_id><profile>OpenworkSolnBuilder</profile><session_id>0</session_id><return_location type=\"Error\">https://reapext.assureweb.co.uk/UI/Extranet/error.aspx</return_location><return_location type=\"Success\">https://reapext.assureweb.co.uk/UI/Extranet/success.aspx?TransactionId=c40d7785-5167-41ba-9ed6-a42f5f038611</return_location><tpsdata><customer_id>31a6bf10-f32a-4f40-ba63-81a468bd7b20</customer_id><exit_timestamp>2019-01-22T14:15:49</exit_timestamp><businesstypeid /></tpsdata></browser></m_control><m_content><b_control><intermediary_case_reference_number>1000116872</intermediary_case_reference_number><quote_type>Comparison</quote_type><quote_or_print>Quote Only</quote_or_print><message_version_number>3.8</message_version_number><submission_date>2019-01-22</submission_date></b_control><intermediary type=\"IFA\"><sib_number>461598</sib_number><FirmFSARef>461598</FirmFSARef><basis_of_sale><whole_of_market>Yes</whole_of_market></basis_of_sale><company_name>Assureweb Firm</company_name><agency_address><line_1>Ellenborough House</line_1><line_2>Wellington Street</line_2><line_3 /><line_4>Cheltenham</line_4><postcode>GL50 1YW</postcode></agency_address></intermediary><application><personal_client id=\"pc1\"><title>Mr</title><forenames>John</forenames><surname>Barnes</surname><sex>Male</sex><date_of_birth>1981-04-04</date_of_birth></personal_client><product product_code=\"GRY\" type=\"Term Protection\"><main_purpose>Personal</main_purpose><number_of_lives_assured>1</number_of_lives_assured><increment_ind>No</increment_ind><benefits_required><life_assured personal_client_id=\"pc1\" sequence_number=\"1\" /><death_ind>Yes</death_ind><death_or_earlier_cic_ind>No</death_or_earlier_cic_ind><critical_illness_ind>No</critical_illness_ind><tpd_ind>No</tpd_ind><waiver_ind>No</waiver_ind></benefits_required><risk_benefit id=\"rb1-1\" type=\"Life And Health\"><cover_basis>Single Life</cover_basis><cover_purpose>Personal</cover_purpose><cover_period><term><years>11</years></term></cover_period><risk_cover><risk_event>Death</risk_event><life_assured personal_client_id=\"pc1\" sequence_number=\"1\" /><lump_sum_benefit><amount currency=\"GBP\">111111</amount></lump_sum_benefit><cover_indexation><change_basis>Level</change_basis><change_index>Level</change_index></cover_indexation></risk_cover><risk_contribution><cost_basis>Paid For Separately</cost_basis><contribution><frequency>Monthly</frequency></contribution><payment_indexation><change_index>Level</change_index></payment_indexation><main_commission commission_entitlement_id=\"ce1\" /><renewal_commission commission_entitlement_id=\"ce2\" /></risk_contribution><risk_benefit_option type=\"Guaranteed Rates\" /></risk_benefit><policy_term><start_date>2019-01-22</start_date></policy_term><commission_entitlement id=\"ce1\" type=\"Initial\"><uplift><percent calculation_basis=\"Entitlement\">100</percent></uplift><indemnity_ind>Yes</indemnity_ind></commission_entitlement><commission_entitlement id=\"ce2\" type=\"Renewal\"><uplift><percent calculation_basis=\"Entitlement\">100</percent></uplift><indemnity_ind>Yes</indemnity_ind></commission_entitlement><illustration_basis><contribution_or_benefit_led>Benefit</contribution_or_benefit_led></illustration_basis><client_specific_illustration><variation element_id=\"rb1-1\" type=\"Add\"><reason><![CDATA[In addition to our 12 month Terminal Illness definition we'll also pay out on definite diagnosis by a UK Consultant of; Cancer (TNM stage 4), Motor Neurone disease, Parkinson's Plus syndrome and Creutzfeldt Jakob disease. See Policy Terms and Conditions for full details.]]></reason></variation><note code=\"CompanyProduct\"><reason><![CDATA[Guaranteed Increase Options (GIOs); These options can be taken up without further medical questions. Cover and premiums will be based on the age of the person covered when the policy started.   Please see Policy Terms and Conditions for full details.]]></reason></note><note code=\"CompanyProduct\"><reason><![CDATA[Premium Waiver is always included at no extra cost and covers incapacity, unemployment, maternity and paternity leave.]]></reason></note><note code=\"CompanyProduct\"><reason><![CDATA[Children's Critical Illness Cover is not automatically included. You can add up to £100,000 of comprehensive Children's Critical Illness Cover  to any other Core Cover,  subject to conditions.]]></reason></note><total_contribution><frequency>Monthly</frequency><gross_amount currency=\"GBP\">8.77</gross_amount><number_of_contributions>132</number_of_contributions><discount_amount currency=\"GBP\">0.00</discount_amount></total_contribution><risk_benefit><benefit_definition risk_benefit_id=\"rb1-1\" /><risk_contribution><amount currency=\"GBP\">8.77</amount><frequency>Monthly</frequency></risk_contribution></risk_benefit><commission_entitlement type=\"Initial\"><commission_requested commission_entitlement_id=\"ce1\" /><payment><amount currency=\"GBP\">210.48</amount><frequency>Annually</frequency></payment></commission_entitlement><commission_entitlement type=\"Renewal\"><commission_requested commission_entitlement_id=\"ce2\" /><payment><amount currency=\"GBP\">0.22</amount><frequency>Monthly</frequency></payment></commission_entitlement></client_specific_illustration></product></application></m_content></message>";
		ot.processOrigo(ELINK_ORIGO_DATA);

	}

	public void processOrigo (String ELINK_ORIGO_DATA) throws Exception {
		OrigoToExtranetTransformer.transformOrigoToNB(ELINK_ORIGO_DATA); 
		
		Interview intty = uk.co.liss.base.underwriting.service.UnderwritingServiceWorker.createAndStartInterview(
				"", null, null, null, "");
		
		while (intty.getOutputScores().iterator().hasNext()) {
			
			
		
			Score score = (Score) intty.getOutputScores().iterator().next();  
			if (score.getScoreGroup().getName().equals("")) {
				
			}
		}
		
	}
	
}
