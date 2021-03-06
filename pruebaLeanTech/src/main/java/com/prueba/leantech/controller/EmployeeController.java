package com.prueba.leantech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.leantech.dtos.EmployeeDTO;
import com.prueba.leantech.services.ActualizarEmployeeI;
import com.prueba.leantech.services.ConsultarEmpleadoServiceI;
import com.prueba.leantech.services.CrearEmpleadoServiceI;
import com.prueba.leantech.services.EliminarEmployeeI;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private CrearEmpleadoServiceI crearEmpleadoService;
	
	@Autowired
	private ConsultarEmpleadoServiceI consultarEmpleadoService;
	
	@Autowired
	private EliminarEmployeeI eliminarEmployee;

	@Autowired
	private ActualizarEmployeeI actualizarEmployee;
	
	@PostMapping(path = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> guardarEmpleado(@RequestBody EmployeeDTO empleado) {
		try {
			return ResponseEntity.ok(crearEmpleadoService.crearEmpleado(empleado));
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(path = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDTO>> verEmpleados(@RequestParam("cargo") String cargo, 
			@RequestParam("nombre") String nombre) {
		try {
			return ResponseEntity.ok(consultarEmpleadoService.consultarEmpleados(nombre, cargo));
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> verEmpleados(@RequestParam("id") Long id) {
		try {
			return ResponseEntity.ok(eliminarEmployee.eliminarEmpleado(id));
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping(path = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> actualizarEmpleado(@RequestBody EmployeeDTO empleado,
			@RequestParam("id") Long id) {
		try {
			return ResponseEntity.ok(actualizarEmployee.actualizarEmpleado(empleado, id));
		} catch (Exception e) {
			return null;
		}
	}
}
