package org.maintech.epp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EppService {
	
	@Autowired
	private EppRepository eppRepository;
	
	public List<Epp> getAllEpp() {
		List<Epp> epps = new ArrayList<>();
		eppRepository.findAll().forEach(epps::add);
		return epps;
	}
	
	public Epp getEpp(Integer id) {
		return eppRepository.findOne(id);
	}

	public void addEpp(Epp topic) {		
		eppRepository.save(topic);
	}

	public void updateEpp(Integer id, Epp topic) {		
		eppRepository.save(topic);
	}

	public void deleteEpp(Integer id) {
		eppRepository.delete(id);
	}
	
	public void softDeleteEpp(Integer id) {
		eppRepository.softDeleteEpp(id);
	}
	
	public List<Object[]> getEppsMainte(Integer id) {
		List<Object[]> lstEpps = new ArrayList<>();
		eppRepository.getEppsMainte(id).forEach(lstEpps::add);
		return lstEpps;
	}
}
