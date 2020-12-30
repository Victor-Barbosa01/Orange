package br.com.OrangeTalents.Banco.controller;

import br.com.OrangeTalents.Banco.entities.Cliente;
import br.com.OrangeTalents.Banco.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.create(cliente),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cliente> mostrar(){
        return clienteService.showAll();
    }

    @GetMapping("/{id}")
    public Cliente mostrarUnico(@PathVariable Long id){
        return clienteService.show(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Cliente cliente = clienteService.show(id);
        boolean deletado = clienteService.delete(cliente);
        String texto = deletado?"Deletado com sucesso":"Cliente não encontrado";
        return new ResponseEntity<>(texto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@Valid @PathVariable Long id, @RequestBody Cliente cliente){
        Cliente cliente1 = clienteService.show(id);
        cliente1.setNome(cliente.getNome());
        cliente1.setCpf(cliente.getCpf());
        cliente1.setEmail(cliente.getEmail());
        cliente1.setData_nascimento(cliente.getData_nascimento());
        return clienteService.update(cliente1);
    }
}
