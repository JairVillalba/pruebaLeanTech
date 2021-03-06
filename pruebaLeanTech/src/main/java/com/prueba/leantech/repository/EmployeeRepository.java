package com.prueba.leantech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.leantech.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByPerson_NameLike(String nombre);

	List<Employee> findByPosition_NameLike(String cargo);

	List<Employee> findByPosition_IdLike(Long idPosition);

	List<Employee> findByPosition_IdLikeOrderBySalaryDesc(Long idPosition);

}
