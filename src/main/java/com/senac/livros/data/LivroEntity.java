
package com.senac.livros.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author davi_
 */
@Entity
@Data //não precisa escrever os métodos construtores, getters e setters
@Table(name = "Livro")
@Component
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String autor;
    private LocalDate lancamento;
    private String titulo;
}
