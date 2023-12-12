
package com.senac.livros.data;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davi_
 */
@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
    
    List<LivroEntity> findByTituloStartingWith(String titulo);
    
    List<LivroEntity> findByTituloEndingWith(String titulo);
    
    List<LivroEntity> findByTituloContains(String titulo);
    
    List<LivroEntity> findByOrderByTituloAsc();
    
    List<LivroEntity> findByOrderByTituloDesc();
    
    List<LivroEntity> findByLancamento(LocalDate lancamento);
    
    List<LivroEntity> findByOrderByLancamentoAsc();
    
    List<LivroEntity> findByOrderByLancamentoDesc();
    
    List<LivroEntity> findByAutorContains(String autor);
}
