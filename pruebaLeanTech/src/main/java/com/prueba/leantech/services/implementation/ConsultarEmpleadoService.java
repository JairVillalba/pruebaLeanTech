package com.prueba.leantech.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.leantech.dtos.EmployeeDTO;
import com.prueba.leantech.dtos.PersonDTO;
import com.prueba.leantech.dtos.PositionDTO;
import com.prueba.leantech.entities.Employee;
import com.prueba.leantech.repository.EmployeeRepository;
import com.prueba.leantech.repository.PositionRepository;
import com.prueba.leantech.services.ConsultarEmpleadoServiceI;

@Service
public class ConsultarEmpleadoService implements ConsultarEmpleadoServiceI{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	public ConsultarEmpleadoService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<EmployeeDTO> consultarEmpleados(String nombre, String cargo) {

		List<Employee> listaEmpleados= new ArrayList<>();
		List<EmployeeDTO> listaEmpleadosDTO= new ArrayList<>();
		
		if(nombre == "" && cargo == "") {
			listaEmpleados =  employeeRepository.findAll();	
		} else if (nombre != "" && cargo == "") {
			listaEmpleados = employeeRepository.findByPerson_NameLike(nombre);
		} else if (nombre == "" && cargo != "") {
			listaEmpleados = employeeRepository.findByPosition_NameLike(cargo);
		}
		
		
		for (Employee employee : listaEmpleados) {
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
			
			listaEmpleadosDTO.add(empleado);
		}
		return listaEmpleadosDTO;
	}

}
