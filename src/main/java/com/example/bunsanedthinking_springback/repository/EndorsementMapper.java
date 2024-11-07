package com.example.bunsanedthinking_springback.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.bunsanedthinking_springback.vo.EndorsementVO;

@Mapper
public interface EndorsementMapper {
	public Optional<EndorsementVO> getById_Customer(int id);

	public Optional<EndorsementVO> getById_ContractManagement(int id);

	public List<EndorsementVO> getAll_ContractManagement();

	public void addById_Customer(int contractId);

	public void updateStatus_ContractManagement(int status, int contract_id);

	public Integer getMaxId();

	public void insert(EndorsementVO endorsementVO);

	public void update(EndorsementVO endorsementVO);

	public void deleteById(int id);
}
