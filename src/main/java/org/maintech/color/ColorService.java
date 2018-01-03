package org.maintech.color;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {

	@Autowired
	private ColorRepository colorRepository;

	public List<Color> getAllColor() {
		List<Color> colores = new ArrayList<>();
		colorRepository.findAll().forEach(colores::add);
		return colores;
	}

	public Color getColor(Integer id) {
		return colorRepository.findOne(id);
	}

	public void addColor(Color color) {
		colorRepository.save(color);
	}

	public void updateColor(Integer id, Color color) { 
		colorRepository.save(color);
	}

	public void deleteColor(Integer id) {
		colorRepository.delete(id);
	}

	public void softDeleteColor(Integer id) {
		colorRepository.softDeleteColor(id);
		
	}
}
