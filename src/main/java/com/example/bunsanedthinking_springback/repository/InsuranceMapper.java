package com.example.bunsanedthinking_springback.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.bunsanedthinking_springback.vo.InsuranceVO;

@Mapper
public interface InsuranceMapper {
	Optional<InsuranceVO> findById_FinancialAccountant(int id);
}
