package com.vehicleinsurancemgt.service;

import java.util.List;

import com.vehicleinsurancemgt.dto.TicketDTO;
import com.vehicleinsurancemgt.exception.DuplicateRecordException;


public interface TicketServiceInt {

	public long add(TicketDTO dto) throws DuplicateRecordException;

	public void delete(TicketDTO dto);

	public TicketDTO findBypk(long pk);

	public TicketDTO findBySubject(String name);

	public void update(TicketDTO dto) throws DuplicateRecordException;

	public List<TicketDTO> list();

	public List<TicketDTO> list(int pageNo, int pageSize);

	public List<TicketDTO> search(TicketDTO dto);

	public List<TicketDTO> search(TicketDTO dto, int pageNo, int pageSize);





}
