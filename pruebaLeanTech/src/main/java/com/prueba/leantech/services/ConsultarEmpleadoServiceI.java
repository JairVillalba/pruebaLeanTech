package com.prueba.leantech.services;

import java.util.List;

import com.prueba.leantech.dtos.EmployeeDTO;

public interface ConsultarEmpleadoServiceI {

	public List<EmployeeDTO> consultarEmpleados(String nombre, String cargo);
}
