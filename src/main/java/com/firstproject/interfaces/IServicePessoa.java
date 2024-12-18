package com.firstproject.interfaces;


import com.firstproject.models.Pessoa;

import java.util.List;

public interface IServicePessoa {
    public Boolean PessoaCriar(Pessoa pessoa);

    public Boolean PessoaEditar(Pessoa pessoa, Long id);

    public Boolean PessoaExcluir(Long id);

    public List<Pessoa> PessoasTodas();

    public List<Pessoa> PessoasNome(String nome);

    public Pessoa PessoaPorId(Long id);
}
