package br.com.OrangeTalents.Banco.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Nome precisa ser preenchido")
    @Length(min = 10, message = "Nome deve ter no mínimo 10 caracteres")
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "E-mail precisa ser preenchido")
    @Email(message = "Email inválido")
    private String email;

    @Column(length = 11, unique = true)
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Não pode ser em branco")
    private Date data_nascimento;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nascimento=" + data_nascimento +
                '}';
    }
}
