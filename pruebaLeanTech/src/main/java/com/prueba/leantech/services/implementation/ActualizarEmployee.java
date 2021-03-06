package com.prueba.leantech.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.leantech.dtos.EmployeeDTO;
import com.prueba.leantech.entities.Employee;
import com.prueba.leantech.entities.Person;
import com.prueba.leantech.entities.Position;
import com.prueba.leantech.repository.EmployeeRepository;
import com.prueba.leantech.repository.PositionRepository;
import com.prueba.leantech.services.ActualizarEmployeeI;

@Service
public class ActualizarEmployee implements ActualizarEmployeeI{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PositionRepository positionRepository;
	
	@Override
	public Long actualizarEmpleado(EmployeeDTO empleado, Long id) {

		
        Employee empleadoActual = employeeRepository.findById(id).orElse(null);
        
        if(empleadoActual == null) {
        	return -1L;
        } else {

    		Person persona = new Person();
    		Position position = new Position();
    		
    		List<Position> cargos = positionRepository.findAll();
    		
    		persona.setName(empleado.getPerson().getName());
    		persona.setLastName(empleado.getPerson().getLastName());
    		persona.setAddress(empleado.getPerson().getAddress());
    		persona.setCellphone(empleado.getPerson().getCellphone());
    		persona.setCityName(empleado.getPerson().getCityName());
    		
    		empleadoActual.setPerson(persona);
    		
    		position.setId(empleado.getPosition().getId());
    		position.setName(empleado.getPosition().getName());
    			
    		empleadoActual.setPosition(position);
    		
    		empleadoActual.setSalary(empleado.getSalary());
    		
    		if (!cargos.contains(position)) {
    			positionRepository.save(position);
    		}
    		
    		employeeRepository.save(empleadoActual);
    		
    		empleado.setId(empleadoActual.getId());
    		return empleado.getId();
        }
	}

}
