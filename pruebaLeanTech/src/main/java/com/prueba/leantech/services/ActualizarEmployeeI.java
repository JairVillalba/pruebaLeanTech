package com.prueba.leantech.services;

import com.prueba.leantech.dtos.EmployeeDTO;

public interface ActualizarEmployeeI {

	public Long actualizarEmpleado(EmployeeDTO empleado, Long id);
}
