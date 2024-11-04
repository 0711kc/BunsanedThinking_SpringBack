package com.example.bunsanedthinking_springback.repository;

import com.example.bunsanedthinking_springback.entity.accidentHistory.AccidentHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccidentHistoryMapper {
    public void insert_accidentHistory_CustomerInformationManagement(@Param("accidentHistory") AccidentHistory accidentHistory);
    public void deleteAccidentHistoriesByCustomerId_CustomerInformationManagement(int customerId);

    public void update_accidentHistory_CustomerInformationManagement(@Param("accidentHistory") AccidentHistory accidentHistory);
    public List<AccidentHistory> findAccidentHistoriesByCustomerId_CustomerInformationManagement(int customerId);
}
