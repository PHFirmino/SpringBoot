package com.firstproject.service;

import com.firstproject.interfaces.IServicePessoa;
import com.firstproject.models.Pessoa;
import com.firstproject.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements IServicePessoa {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public Boolean PessoaCriar(Pessoa pessoa)
    {
        pessoaRepository.save(pessoa);

        return true;
    }
    @Override
    public Boolean PessoaEditar(Pessoa pessoa, Long id)
    {
        var pessoaEditar = pessoaRepository.findById(id);
        pessoaEditar.get().setNome(pessoa.getNome());
        pessoaEditar.get().setEmail(pessoa.getEmail());

        pessoaRepository.save(pessoaEditar.get());

        return true;
    }
    @Override
    public Boolean PessoaExcluir(Long id)
    {
        pessoaRepository.deleteById(id);

        return true;
    }
    @Override
    public List<Pessoa> PessoasTodas()
    {
        var pessoasTodas = pessoaRepository.findAll();

        return pessoasTodas;
    }
    @Override
    public Pessoa PessoaPorId(Long id)
    {
        var pessoaPorId = pessoaRepository.findById(id);

        return pessoaPorId.get();
    }

    @Override
    public List<Pessoa> PessoasNome(String nome)
    {
        var pessoasNome = pessoaRepository.findByNomeLike(nome);

        return pessoasNome;
    }
}
