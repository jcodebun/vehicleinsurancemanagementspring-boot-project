package com.vehicleinsurancemgt.form;

import javax.validation.constraints.NotEmpty;

import com.vehicleinsurancemgt.dto.BaseDTO;
import com.vehicleinsurancemgt.dto.FeedBackDTO;
import com.vehicleinsurancemgt.dto.PolicyDTO;
import com.vehicleinsurancemgt.dto.UserDTO;
import com.vehicleinsurancemgt.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackForm extends BaseForm {

	@NotEmpty(message = "Subject is required")
	private String subject;

	@NotEmpty(message = "Message is required")
	private String message;

	@Override
	public BaseDTO getDTO() {
		FeedBackDTO bean = new FeedBackDTO();
		bean.setId(id);
		bean.setSubject(subject);
		bean.setMessage(message);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO baseBean) {
		FeedBackDTO bean = (FeedBackDTO) baseBean;
		id = bean.getId();
		subject = bean.getSubject();
		message = bean.getMessage();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}
}
