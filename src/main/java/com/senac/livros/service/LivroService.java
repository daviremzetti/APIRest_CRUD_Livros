
package com.senac.livros.service;

import com.senac.livros.data.LivroEntity;
import com.senac.livros.data.LivroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davi_
 */
@Service
public class LivroService {
    
    @Autowired
    LivroRepository repository;
    
    public LivroEntity cadastrarLivro(LivroEntity livro){
        repository.save(livro);
        return livro;
    }
    
    public LivroEntity atualizarLivro(Integer id, LivroEntity livroAtualizado){
        LivroEntity livro = repository.findById(id).orElse(null);
        livro.setAutor(livroAtualizado.getAutor());
        livro.setLancamento(livroAtualizado.getLancamento());
        livro.setTitulo(livroAtualizado.getTitulo());
        repository.save(livro);
        return livro;
    }
    
    public List<LivroEntity> buscarTodosLivros(){
        List<LivroEntity> livros = repository.findAll();
        return livros;
    }
    
    public LivroEntity buscarLivroID(Integer id){
        LivroEntity livro = repository.findById(id).orElse(null);
        return livro;
    }
    
    public void deletarLivro(Integer id){
        repository.deleteById(id);
    }
    
    public List<LivroEntity> buscarTituloContemTexto(String titulo){
        List<LivroEntity> livros = repository.findByTituloContains(titulo);
        return livros;
    }
    
    public List<LivroEntity> buscarLivroComecaTexto(String texto){
        List<LivroEntity> livros = repository.findByTituloStartingWith(texto);
        return livros;
    }
    
    public List<LivroEntity> buscarLivroTerminaTexto(String texto){
        List<LivroEntity> livros = repository.findByTituloEndingWith(texto);
        return livros;
    }
    
    public List<LivroEntity> buscarLivroAutorContemTexto(String texto){
        List<LivroEntity> livros = repository.findByAutorContains(texto);
        return livros;
    }
}
