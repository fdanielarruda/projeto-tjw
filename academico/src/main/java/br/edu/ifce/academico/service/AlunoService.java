package br.edu.ifce.academico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.academico.dto.AlunoNotas;
import br.edu.ifce.academico.model.Aluno;
import br.edu.ifce.academico.model.Curso;
import br.edu.ifce.academico.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}
	
	public List<Aluno> listarAlunosPorNomeOuMatriculaECurso(String pesquisa, Curso curso) { 
		return alunoRepository.findByCursoAndNomeContainingOrCursoAndMatriculaContaining(curso, pesquisa, curso, pesquisa);
	}
	
	public Aluno consultarAluno(Long id_aluno) {
		return alunoRepository.findById(id_aluno).get();
	}
	
	public List<AlunoNotas> consultarAlunosNotasDaTurma(Long turma_id) {
		return alunoRepository.getAlunosNotasDaTurma(turma_id);
	}
	
	public void salvarAluno(Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		alunoRepository.delete(aluno);
	}
}
