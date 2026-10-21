package com.vehicleinsurancemgt.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.vehicleinsurancemgt.dto.BaseDTO;
import com.vehicleinsurancemgt.dto.FeedBackDTO;
import com.vehicleinsurancemgt.dto.PolicyDTO;
import com.vehicleinsurancemgt.dto.TicketDTO;
import com.vehicleinsurancemgt.dto.UserDTO;
import com.vehicleinsurancemgt.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketForm extends BaseForm {

	@NotEmpty(message ="Issue is required")
	private String issue;
	private String ticketId;
	@NotEmpty(message ="Message is required")
	private String message;
	private String status;
	private String comment;

	@Override
	public BaseDTO getDTO() {
		TicketDTO bean = new TicketDTO();
		bean.setId(id);
		bean.setIssue(issue);
		bean.setTicketId(DataUtility.getLong(ticketId));
		bean.setMessage(message);
		bean.setStatus(status);
		bean.setComment(comment);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO baseBean) {
		TicketDTO bean = (TicketDTO) baseBean;
		id = bean.getId();
		issue = bean.getIssue();
		message = bean.getMessage();
		ticketId=String.valueOf(bean.getTicketId());
		status=bean.getStatus();
		comment=bean.getComment();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}
}
