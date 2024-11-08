package com.example.bunsanedthinking_springback.model.domain.additionalAllowance;

import com.example.bunsanedthinking_springback.entity.paymentDetail.AdditionalAllowance;
import com.example.bunsanedthinking_springback.repository.AdditionalAllowanceMapper;
import com.example.bunsanedthinking_springback.repository.PaymentDetailMapper;
import com.example.bunsanedthinking_springback.vo.AdditionalAllowanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdditionalAllowanceDModel {
	@Autowired
	private PaymentDetailMapper paymentDetailMapper;
	@Autowired
	private AdditionalAllowanceMapper additionalAllowanceMapper;

	public AdditionalAllowance getById(int id) {
		return paymentDetailMapper.findById_FinancialAccountant(id)
			.flatMap(detailVO ->
				additionalAllowanceMapper.getById(id)
					.map(additionalAllowanceVO -> additionalAllowanceVO.getEntity(detailVO)))
			.orElse(null);
	}

	public List<AdditionalAllowance> getAll() {
		List<AdditionalAllowance> additionalAllowances = new ArrayList<AdditionalAllowance>();
		List<AdditionalAllowanceVO> additionalAllowanceVOS = additionalAllowanceMapper.getAll();
		additionalAllowanceVOS.forEach(e -> additionalAllowances.add(getById(e.getPayment_detail_id())));
		return additionalAllowances;
	}

	public Integer getMaxId() {
		return additionalAllowanceMapper.getMaxId();
	}

	public void add(AdditionalAllowance additionalAllowance) {
		if (additionalAllowance == null) return;
		if (additionalAllowanceMapper.getById(additionalAllowance.getId()).isPresent()) return;
		paymentDetailMapper.insert_LoanManagement(additionalAllowance.getPaymentDetailVO());
		additionalAllowanceMapper.insert(additionalAllowance.getVO());
	}

	public void update(AdditionalAllowance additionalAllowance) {
		if (additionalAllowance == null) return;
		if (additionalAllowanceMapper.getById(additionalAllowance.getId()).isEmpty()) return;
		additionalAllowanceMapper.update(additionalAllowance.getVO());
		paymentDetailMapper.update_FinancialAccountant(additionalAllowance.getPaymentDetailVO());
	}

	public void delete(int id) {
		if (additionalAllowanceMapper.getById(id).isEmpty()) return;
		additionalAllowanceMapper.deleteById(id);
		paymentDetailMapper.deleteById(id);
	}
}
