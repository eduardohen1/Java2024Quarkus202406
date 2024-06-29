package es.com.minsait.service;

import es.com.minsait.model.Pessoa;
import es.com.minsait.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GreetingService {

    @Inject
    PessoaRepository pessoaRepository;

    public String greet() {
        return "Hello form GreetingService!";
    }

    @Transactional
    public String greetPessoa(Pessoa p){
        try {
            pessoaRepository.persist(p);
            //Pessoa p1 = pessoaRepository.save(p); <- spring
        }catch (Exception e){
            return "Erro ao cadastrar pessoa: " + e.getMessage();
        }
        return "Cadastro de pessoa: \n" + p.toString();
    }

}
