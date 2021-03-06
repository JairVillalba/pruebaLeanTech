package com.prueba.leantech.dtos;

public class EmployeeDTO {

	private long id;
	private PersonDTO person;
	private PositionDTO position;
	private Long salary;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public PositionDTO getPosition() {
		return position;
	}
	public void setPosition(PositionDTO position) {
		this.position = position;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}
