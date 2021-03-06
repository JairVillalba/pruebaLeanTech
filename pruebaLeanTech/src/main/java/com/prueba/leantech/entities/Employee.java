package com.prueba.leantech.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {

	@Id
	@GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
	@GeneratedValue(generator = "SEQ_VALOR")
	private long id;
	
    @OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "person", referencedColumnName = "id")
	private Person person;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "position", referencedColumnName = "id")
	private Position position;
	
	private Long salary;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}
