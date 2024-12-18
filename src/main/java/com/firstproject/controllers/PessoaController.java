package com.firstproject.controllers;
//import com.firstproject.interfaces.IServicePessoa;
import com.firstproject.interfaces.IServicePessoa;
import com.firstproject.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PessoaController {

    @Autowired
    IServicePessoa iServicePessoa;


    @GetMapping("/pessoasTodas")
    public ResponseEntity<List<Pessoa>> PessoaTodas(){

        var pessoasTodas = iServicePessoa.PessoasTodas();

        return ResponseEntity.ok(pessoasTodas);
    }

    @GetMapping("/pessoasPorNome")
    public ResponseEntity<List<Pessoa>> PessoaPorNome(@RequestParam String nome){

        var pessoasPorNome = iServicePessoa.PessoasNome("%"+nome+"%");

        return ResponseEntity.ok(pessoasPorNome);
    }
    @GetMapping("/pessoaPorId/{id}")
    public ResponseEntity<Pessoa> PessoaPorId(@PathVariable Long id){

        var pessoaPorId = iServicePessoa.PessoaPorId(id);

        return ResponseEntity.ok(pessoaPorId);

    }

    @PostMapping("/pessoasCriar")
    public ResponseEntity<String> PessoaCriar(@RequestBody Pessoa pessoa){

        return iServicePessoa.PessoaCriar(pessoa)
                ? ResponseEntity.ok("Criado com sucesso")
                : ResponseEntity.ok("Ocorreu algum erro");
    }

    @PutMapping("/pessoaEditar/{id}")
    public ResponseEntity<String> PessoaTodas(@RequestBody Pessoa pessoa, @PathVariable Long id){

        var pessoaEditar = iServicePessoa.PessoaEditar(pessoa, id);

        return iServicePessoa.PessoaEditar(pessoa, id)
                ? ResponseEntity.ok("Editado com sucesso")
                : ResponseEntity.ok("Ocorreu algum erro");
    }
    @DeleteMapping("/pessoaExcluir/{id}")
    public ResponseEntity<String> PessoaExcluir(@PathVariable Long id){

        return iServicePessoa.PessoaExcluir(id)
                ? ResponseEntity.ok("Excluido com sucesso")
                : ResponseEntity.ok("Ocorreu algum erro");
    }



}
