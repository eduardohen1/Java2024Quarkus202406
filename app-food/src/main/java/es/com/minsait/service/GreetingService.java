package es.com.minsait.service;

import es.com.minsait.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GreetingService {

    public String greet() {
        return "Hello form GreetingService!";
    }

    @Transactional
    public String greetPessoa(Pessoa p){
        try {
            p.persist();
            //Pessoa p1 = pessoaRepository.save(p); <- spring
        }catch (Exception e){
            return "Erro ao cadastrar pessoa: " + e.getMessage();
        }
        return "Cadastro de pessoa: \n" + p.toString();
    }

}
