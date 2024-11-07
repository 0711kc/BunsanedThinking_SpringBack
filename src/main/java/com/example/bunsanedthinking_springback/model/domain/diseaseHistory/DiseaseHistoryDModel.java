package com.example.bunsanedthinking_springback.model.domain.diseaseHistory;

import com.example.bunsanedthinking_springback.entity.diseaseHistory.DiseaseHistory;
import com.example.bunsanedthinking_springback.repository.DiseaseHistoryMapper;
import com.example.bunsanedthinking_springback.vo.DiseaseHistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiseaseHistoryDModel {
    @Autowired
    private DiseaseHistoryMapper diseaseHistoryMapper;
    public DiseaseHistory getById(int id) {
        DiseaseHistoryVO diseaseHistoryVO = diseaseHistoryMapper.getById(id).orElse(null);
        return new DiseaseHistory(diseaseHistoryVO);
    }
    public List<DiseaseHistory> getAll() {
        List<DiseaseHistory> diseaseHistories = new ArrayList<DiseaseHistory>();
        diseaseHistoryMapper.getAll().stream().forEach(e -> diseaseHistories.add(new DiseaseHistory(e)));
        return diseaseHistories;
    }
    public int getMaxId() {
        return diseaseHistoryMapper.getMaxId_SalesModel();
    }
    public void add(DiseaseHistoryVO diseaseHistoryVO) {
        diseaseHistoryMapper.insert_SalesModel(diseaseHistoryVO);
    }
    public void update(DiseaseHistoryVO diseaseHistoryVO) {
        diseaseHistoryMapper.update(diseaseHistoryVO);
    }
    public void delete(int id) {
        diseaseHistoryMapper.deleteById(id);
    }
}