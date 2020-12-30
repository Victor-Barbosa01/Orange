package br.com.OrangeTalents.Banco.repositories;

import br.com.OrangeTalents.Banco.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
