package com.prueba.leantech.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.leantech.dtos.EmployeeDTO;
import com.prueba.leantech.dtos.PersonDTO;
import com.prueba.leantech.dtos.PositionConsultaDTO;
import com.prueba.leantech.dtos.PositionDTO;
import com.prueba.leantech.entities.Employee;
import com.prueba.leantech.entities.Position;
import com.prueba.leantech.repository.EmployeeRepository;
import com.prueba.leantech.repository.PositionRepository;
import com.prueba.leantech.services.ConsultarPositionServiceI;

@Service
public class ConsultarPositionService implements ConsultarPositionServiceI{

	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<PositionConsultaDTO> consultarEmpleadosCargo() {

		List<PositionConsultaDTO> cargos = new ArrayList<>();
		
		List<Position> positions = new ArrayList<>(); 
		positions = positionRepository.findAll();
		
		for (Position position : positions) {
			PositionConsultaDTO cargo = new PositionConsultaDTO();
			
			cargo.setId(position.getId());
			cargo.setName(position.getName());
			cargo.setEmployees(employeePosition(cargo.getId()));
			
			cargos.add(cargo);
		}
		return cargos;
	}
	
	private List<EmployeeDTO> employeePosition(Long idPosition){
		
		List<Employee> empleados = employeeRepository.findByPosition_IdLikeOrderBySalaryDesc(idPosition);
		List<EmployeeDTO> empleadosDTO = new ArrayList<>();
		
		for (Employee employee : empleados) {
			EmployeeDTO empleado = new EmployeeDTO();
			PersonDTO persona = new PersonDTO();
			PositionDTO position = new PositionDTO();
			
			empleado.setId(employee.getId());
			
//			persona.setId(employee.getPerson().getId());
			persona.setName(employee.getPerson().getName());
			persona.setLastName(employee.getPerson().getLastName());
			persona.setAddress(employee.getPerson().getAddress());
			persona.setCellphone(employee.getPerson().getCellphone());
			persona.setCityName(employee.getPerson().getCityName());
			
			empleado.setPerson(persona);
			
			position.setId(employee.getPosition().getId());
			position.setName(employee.getPosition().getName());
			
			empleado.setPosition(position);
			
			empleado.setSalary(employee.getSalary());
			
			empleadosDTO.add(empleado);
		}
		return empleadosDTO;
	}

}
