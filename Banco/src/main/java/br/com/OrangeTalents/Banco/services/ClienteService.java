package br.com.OrangeTalents.Banco.services;

import br.com.OrangeTalents.Banco.repositories.ClienteRepository;
import br.com.OrangeTalents.Banco.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente create(Cliente cliente){
        return this.repository.save(cliente);
    }

    public Cliente update(Cliente cliente){
        return this.repository.save(cliente);

    }

    public boolean delete(Cliente cliente){
        try {
            this.repository.delete(cliente);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public List<Cliente> showAll(){
        return this.repository.findAll();
    }

    public Cliente show(Long id){
        return this.repository.findById(id).orElse(null);
    }
}
