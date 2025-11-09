package com.fernandes.barbershop_agendamento_cabelereiro_api.service;

import com.fernandes.barbershop_agendamento_cabelereiro_api.entity.Pessoa;
import com.fernandes.barbershop_agendamento_cabelereiro_api.exception.pessoaException.PessoaNotFoundException;
import com.fernandes.barbershop_agendamento_cabelereiro_api.repository.PessoaRepository;
import com.fernandes.barbershop_agendamento_cabelereiro_api.service.interfaces.PessoaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaImpl implements PessoaInterface {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa create(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa findById(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        return pessoa.orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada!"));
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        Pessoa pessoaBanco = findById(pessoa.getId());

        pessoaBanco.setNome(pessoa.getNome());
        pessoaBanco.setCpf(pessoa.getCpf());
        pessoaBanco.setTelefone(pessoa.getTelefone());

        return pessoaRepository.save(pessoaBanco);
    }

    @Override
    public void excluir(Long id) {
        Pessoa pessoaBanco = findById(id);

        pessoaRepository.delete(pessoaBanco);
    }
}
