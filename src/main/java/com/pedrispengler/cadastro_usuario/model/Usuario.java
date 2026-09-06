package com.pedrispengler.cadastro_usuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Diz ao Spring Boot que esta classe é uma entidade do JPA e deve ser mapeada para uma tabela no banco de dados.
@Table(name = "usuarios") // Define o nome exato da tabela que será gerada no banco de dados.
@Getter // Getter e Setter geram os métodos de leitura e escrita para os atributos em tempo de compilação (graças ao Lombok).
@Setter
@NoArgsConstructor // NoArgs e AllArgs geram o construtor vazio (obrigatório para o JPA funcionar) e o construtor com todos os campos.
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O email não pode ser vazio")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha não pode ser vazio")
    @Column(nullable = false)
    private String senha;
}