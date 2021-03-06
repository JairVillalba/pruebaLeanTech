package com.prueba.leantech.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.leantech.dtos.EmployeeDTO;
import com.prueba.leantech.dtos.PersonDTO;
import com.prueba.leantech.dtos.PositionDTO;
import com.prueba.leantech.entities.Employee;
import com.prueba.leantech.repository.EmployeeRepository;
import com.prueba.leantech.services.EliminarEmployeeI;

@Service
public class EliminarEmployee implements EliminarEmployeeI{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDTO eliminarEmpleado(Long id) {
		
		EmployeeDTO empleadoEliminadoDTO = new EmployeeDTO();
		Employee empleadoEliminado = employeeRepository.findById(id).orElse(null);
		
		PersonDTO persona = new PersonDTO();
		PositionDTO position = new PositionDTO();
		
		persona.setName(empleadoEliminado.getPerson().getName());
		persona.setLastName(empleadoEliminado.getPerson().getLastName());
		persona.setAddress(empleadoEliminado.getPerson().getAddress());
		persona.setCellphone(empleadoEliminado.getPerson().getCellphone());
		persona.setCityName(empleadoEliminado.getPerson().getCityName());
		
		empleadoEliminadoDTO.setPerson(persona);
		
		position.setId(empleadoEliminado.getPosition().getId());
		position.setName(empleadoEliminado.getPosition().getName());
		
		empleadoEliminadoDTO.setPosition(position);
		
		empleadoEliminadoDTO.setSalary(empleadoEliminado.getSalary());
		
		employeeRepository.deleteById(id);
		return empleadoEliminadoDTO;
	}

}
