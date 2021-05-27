package org.serratec.backend.projeto01.controllers;

import java.util.List;

import org.serratec.backend.projeto01.entity.CalculatorEntity;
import org.serratec.backend.projeto01.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculatorController {
	
	@Autowired
    CalculatorService service;
	
	@PostMapping("/calc")
	public Integer calc(@RequestBody CalculatorEntity calculator) {
		return service.calc(calculator);
	}
	
	@PostMapping("/criar")
	public void criar(@RequestBody CalculatorEntity calculator) {
		service.create(calculator);
	}
	
	@GetMapping("/visualizar")
	public List<CalculatorEntity> visualizar() {
		return service.getAll();
	}
	
	@GetMapping("/procurar/{number1}")
	public CalculatorEntity procurar(@PathVariable Integer number1) {
		return service.procurar(number1);
	}

}
