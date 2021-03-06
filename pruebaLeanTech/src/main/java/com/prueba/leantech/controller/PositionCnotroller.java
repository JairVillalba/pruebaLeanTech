package com.prueba.leantech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.leantech.dtos.PositionConsultaDTO;
import com.prueba.leantech.services.implementation.ConsultarPositionService;

@RestController
@RequestMapping("/position")
public class PositionCnotroller {

	@Autowired
	private ConsultarPositionService consultarPositionService;
	
	@GetMapping(path = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PositionConsultaDTO>> consultarCargos() {
		try {
			return ResponseEntity.ok(consultarPositionService.consultarEmpleadosCargo());
		} catch (Exception e) {
			return null;
		}
	}
}
