package com.vehicleinsurancemgt.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.vehicleinsurancemgt.dto.BaseDTO;
import com.vehicleinsurancemgt.dto.BuyPolicyDTO;
import com.vehicleinsurancemgt.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BuyPolicyForm extends BaseForm {

	private long poilicyId;
	private String policyName;
	private String roi;
	private String duration;
	private String price;
	@NotEmpty(message = "First Name is required")
	private String firstName;
	@NotEmpty(message = "Last Name is required")
	private String lastName;
	@NotEmpty(message = "Email Id is required")
	private String email;
	@NotEmpty(message = "Contact No is required")
	private String contactNo;
	@NotEmpty(message = "Date of Birth is required")
	private String dob;
	@NotEmpty(message = "Vehicle Number is required")
	private String vehicleNumber;
	

	private String renewalDate;

	private Date buyDate;

	@Override
	public BaseDTO getDTO() {
		BuyPolicyDTO bean = new BuyPolicyDTO();
		bean.setPoilicyId(poilicyId);
		bean.setPolicyName(policyName);
		bean.setRoi(roi);
		bean.setDuration(duration);
		bean.setPrice(price);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmail(email);
		bean.setContactNo(contactNo);
		bean.setDob(DataUtility.getDate(dob));
		bean.setRenewalDate(DataUtility.getDate(renewalDate));
		bean.setBuyDate(buyDate);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		BuyPolicyDTO bean = (BuyPolicyDTO) bDto;
		poilicyId = bean.getId();
		policyName = bean.getPolicyName();
		roi = bean.getRoi();
		duration = bean.getDuration();
		price = bean.getPrice();
		firstName = bean.getFirstName();
		lastName = bean.getLastName();
		email = bean.getEmail();
		contactNo = bean.getContactNo();
		dob = DataUtility.getDateString(bean.getDob());
		renewalDate = DataUtility.getDateString(bean.getRenewalDate());
		buyDate = bean.getBuyDate();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
