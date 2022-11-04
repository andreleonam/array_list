package Entities;

import javax.naming.spi.DirStateFactory.Result;

public class Funcionario {

	private Integer id;
	private String name;
	private Double salario;
	
	public Funcionario() {
	}

	public Funcionario(Integer id, String name, Double salario) {
		this.id = id;
		this.name = name;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getSalario() {
		return salario;
	}
	
	public void aumentarSalario(Double percentual) {
		this.salario = this.salario * (1 + (percentual / 100));
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", name=" + name + ", salario=" + salario + "]";
	}
	
	
}
