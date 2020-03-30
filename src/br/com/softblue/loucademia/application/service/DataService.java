package br.com.softblue.loucademia.application.service;

import java.util.List;

import javax.ejb.EJB;

import javax.ejb.Stateless;

import br.com.softblue.loucademia.domain.aluno.Estado;
import br.com.softblue.loucademia.domain.aluno.EstadoRepository;
import br.com.softblue.loucademia.domain.aluno.Aluno.Sexo;
import br.com.softblue.loucademia.domain.aluno.Aluno.Situacao;

//EJB's para a l�gica do sistema.
//N�o se cria vari�veis, somente m�tdos.

@Stateless
public class DataService {

	@EJB
	private EstadoRepository estadoRepository;

	public List<Estado> listEstados() {
		List<Estado> estados = estadoRepository.listEstados();
		return estados;
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}

	public Situacao[] getSituacoes() {
		return Situacao.values();
	}
}