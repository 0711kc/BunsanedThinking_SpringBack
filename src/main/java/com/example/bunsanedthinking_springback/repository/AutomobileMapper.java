package com.example.bunsanedthinking_springback.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.bunsanedthinking_springback.vo.AutoMobileVO;

@Mapper
public interface AutomobileMapper {
	public Optional<AutoMobileVO> getById_Customer(int id);

	public List<AutoMobileVO> getAll_Customer();

	ArrayList<AutoMobileVO> getAllAutomobileInsurance_SalesModel();

	void insert_ProductManagement(AutoMobileVO automobileVO);

	void update_ProductManagementModel(AutoMobileVO automobileVO);

	Optional<AutoMobileVO> findById_FinancialAccountant(int id);

	AutoMobileVO getById_ProductManagementModel(int id);

	public void deleteById(int id);

	public Integer getMaxId();
}
