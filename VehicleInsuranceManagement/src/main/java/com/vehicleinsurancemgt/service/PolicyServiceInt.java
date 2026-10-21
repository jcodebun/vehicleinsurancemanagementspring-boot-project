package com.vehicleinsurancemgt.service;

import java.util.List;

import com.vehicleinsurancemgt.dto.PolicyDTO;
import com.vehicleinsurancemgt.exception.DuplicateRecordException;


public interface PolicyServiceInt {

	public long add(PolicyDTO dto) throws DuplicateRecordException;

	public void delete(PolicyDTO dto);

	public PolicyDTO findBypk(long pk);

	public PolicyDTO findByName(String name);

	public void update(PolicyDTO dto) throws DuplicateRecordException;

	public List<PolicyDTO> list();

	public List<PolicyDTO> list(int pageNo, int pageSize);

	public List<PolicyDTO> search(PolicyDTO dto);

	public List<PolicyDTO> search(PolicyDTO dto, int pageNo, int pageSize);





}
