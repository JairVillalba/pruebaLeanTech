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
import com.prueba.leantech.services.CrearEmpleadoServiceI;

@Service
public class CrearEmpleadoService implements CrearEmpleadoServiceI {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	public CrearEmpleadoService(EmployeeRepository employeeRepository,
			PositionRepository positionRepository) {
		this.employeeRepository = employeeRepository;
		this.positionRepository = positionRepository;
	}
	
	@Override
	public EmployeeDTO crearEmpleado(EmployeeDTO empleado) {
		
		Employee employee = new Employee();
		Person persona = new Person();
		Position position = new Position();
		
		List<Position> cargos = positionRepository.findAll();
		
		persona.setName(empleado.getPerson().getName());
		persona.setLastName(empleado.getPerson().getLastName());
		persona.setAddress(empleado.getPerson().getAddress());
		persona.setCellphone(empleado.getPerson().getCellphone());
		persona.setCityName(empleado.getPerson().getCityName());
		
		employee.setPerson(persona);
		
		position.setId(empleado.getPosition().getId());
		position.setName(empleado.getPosition().getName());
			
		employee.setPosition(position);
		
		employee.setSalary(empleado.getSalary());
		
		if (cargos != null && !cargos.contains(position)) {
			positionRepository.save(position);
		}
		
		employeeRepository.save(employee);
		
		empleado.setId(employee.getId());
		return empleado;
	}

}
