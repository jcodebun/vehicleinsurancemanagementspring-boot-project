package com.vehicleinsurancemgt.form;

import javax.validation.constraints.Min;

import com.vehicleinsurancemgt.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RenewalForm extends BaseForm {
	
	private long oldPolicyId;
	@Min(value = 1,message = "New Policy Required")
	private long newPolicyId;
	

	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		
	}

}
