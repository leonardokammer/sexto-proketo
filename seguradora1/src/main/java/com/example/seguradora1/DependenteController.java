package com.example.seguradora1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dependente")
public class DependenteController {

  @Autowired
  private DependenteRepository dependenteRepository;

  @PostMapping(path = "/insere") // Map ONLY POST Requests
  public @ResponseBody String addNewCliente(@RequestParam String nome, @RequestParam Integer idade,
      @RequestParam String cliente
      
        ) {

            Dependente c = new Dependente();

            c.setNome(nome);
            c.setIdade(idade);
     

  c.setCliente(cliente);

            dependenteRepository.save(c);

            

          

            return "Inserido";
    }

    @GetMapping(path="/lista")
  public @ResponseBody Iterable<Dependente> getAllCliente() {
    // This returns a JSON or XML with the users
    return dependenteRepository.findAll();
  }
}
