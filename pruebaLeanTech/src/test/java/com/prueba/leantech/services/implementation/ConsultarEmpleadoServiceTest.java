package com.prueba.leantech.services.implementation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prueba.leantech.dtos.EmployeeDTO;
import com.prueba.leantech.dtos.PersonDTO;
import com.prueba.leantech.dtos.PositionDTO;
import com.prueba.leantech.entities.Employee;
import com.prueba.leantech.entities.Person;
import com.prueba.leantech.entities.Position;
import com.prueba.leantech.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class ConsultarEmpleadoServiceTest {

	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	private ConsultarEmpleadoService consultarEmpleadoService;
	
	private 
	EmployeeDTO employeeDTO;
	PersonDTO personaDTO;
	PositionDTO positionDTO;
	
	Employee employee;
	Person persona;
	Position position;
	List<Position> listaCargos;
	
	@BeforeEach
	public void inicializa() {
		employeeDTO = new EmployeeDTO();
		employeeDTO.setId(1L);
		
		personaDTO = new PersonDTO();
		personaDTO.setName("Jair");
		personaDTO.setLastName("Villalba");
		personaDTO.setAddress("Cra");
		personaDTO.setCellphone(311285);
		personaDTO.setCityName("Bogota");
		
		employeeDTO.setPerson(personaDTO);
		
		positionDTO = new PositionDTO();
		positionDTO.setId(1L);
		positionDTO.setName("dev");
		
		employeeDTO.setPosition(positionDTO);
		
		employeeDTO.setSalary(10000L);
		
		employee = new Employee();
		employee.setId(1L);
		
		persona = new Person();
		persona.setName("Jair");
		persona.setLastName("Villalba");
		persona.setAddress("Cra");
		persona.setCellphone(311285);
		persona.setCityName("Bogota");
		
		employee.setPerson(persona);
		
		
		List<Position> listaCargos = new ArrayList<>();
		position = new Position();
		position.setId(1L);
		position.setName("dev");
		
		listaCargos.add(position);
		
		employee.setPosition(position);
		
		employee.setSalary(10000L);
		
	}
	
	@Test
	void testCrearEmpleadoService() {
		consultarEmpleadoService = new ConsultarEmpleadoService(employeeRepository);
		List<EmployeeDTO> empleados = consultarEmpleadoService.consultarEmpleados(null, null);
		
		assertNotNull(empleados);
	}
	
	@Test
	void testCrearEmpleadoServiceAll() {
		List<Employee> listaEmpleados = new ArrayList<>();		
		listaEmpleados.add(employee);
		when(employeeRepository.findAll()).thenReturn(listaEmpleados);
		consultarEmpleadoService = new ConsultarEmpleadoService(employeeRepository);
		List<EmployeeDTO> empleados = consultarEmpleadoService.consultarEmpleados("", "");
		
		assertNotNull(empleados);
	}
}
