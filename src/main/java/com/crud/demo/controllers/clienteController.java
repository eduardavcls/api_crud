package com.crud.demo.controllers;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import com.crud.demo.classes.Cliente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("clientes")

public class clienteController {
 // Buscar todos os clientes - getAll
 @GetMapping
 public String getAll() {
     if (!Cliente.clientes.isEmpty()) {
         return "Não há clientes cadastrados.";
     } else {
         String resposta = Cliente.clientes.toString();
         return resposta;
     }
 }

 // Criar um cliente - create
 @PostMapping
 public String create(@RequestBody Cliente cliente) {
     Cliente.clientes.add(cliente);
     return "Cliente cadastrado com sucesso!";
 }

 // Buscar um cliente por id - getById
 @GetMapping("/{id}")
 public String getById(@PathVariable UUID id) {
     for (Cliente cliente : Cliente.clientes) {
         if (cliente.getId().equals(id)) {
             return cliente.toString();
         }
     }
     return "Cliente não encontrado.";
 }

 // adicionar um cliente - 
    @PostMapping("/add_cliente")
    public String addCliente(@RequestBody Cliente cliente) {
    System.out.println("Adicionando um cliente...");
    Cliente.clientes.add(cliente);
        return "Cliente cadastrado com sucesso!";
    }
    




 // Deletar um cliente - delete
   @DeleteMapping("/delete_cliente/{id}")
   public String deleteCliente(@PathVariable UUID id) {
    for (Cliente cliente : Cliente.clientes){
        if (cliente.getId().equals(id)) {
            Cliente.clientes.remove(cliente);
        }
    }
    return "Cliente deletado com sucesso!";
   
}
// atualiza cliente
  @PutMapping("/{id}")
  public String updateCliente(@PathVariable UUID id, @RequestBody Cliente clienteNovo) {
      for(Cliente cliente : Cliente.clientes){
        cliente.setNome(clienteNovo.getNome());
      }
      
      return "Cliente atualizado com sucesso!";
  }


}