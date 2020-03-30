package br.com.softblue.loucademia.domain.aluno;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import br.com.softblue.loucademia.application.util.StringUtils;

@Entity
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID", nullable=false, length=8)
	private String matricula; 
	
	@Column(name="NOME", nullable=false, length=64)
	private String nome; 
	
	@Column(name="EMAIL", nullable=false, length=64)
	private String email;

	public enum Sexo {
		Masculino, Feminino;
	}

	@Enumerated
	@Column(name="SEXO", nullable=false, length=1)
	private Sexo sexo;
	
	@Column(name="RG", nullable=false, length=10)
	private Integer rg;

	@Column(name="NASCIMENTO", nullable=false)
	private LocalDate dataNascimento;

	@Embedded
	private Endereco endereco = new Endereco();

	@Embedded
	private Telefone telefone = new Telefone();

	public enum Situacao {
		Ativo, Inativo, Pendente
	}

	@Enumerated
	@Column(name="SITUACAO", nullable=false, length=1)
	private Situacao situacao;
	
	//Gera a matrícula com o ano atual. Ex: 20190001.
	public void gerarMatricula(String maxMatricula) {
		//Esta clase e método traz o ano atual.
		Year year = Year.now();
		
		if (maxMatricula == null) {
			maxMatricula = year + StringUtils.leftZeroes(0, 4);
		}
		
		int sequencial = Integer.parseInt(maxMatricula.substring(4));
		sequencial++;
		
		this.matricula = year + StringUtils.leftZeroes(sequencial, 4);
	}
	
	//Método apenas para mostrar os dados do Objeto.
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", email=" + email + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}
	
	//Métodos hashCode e Equals, precisam ser feitos para garantir que o ID do Aluno é único.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
}
