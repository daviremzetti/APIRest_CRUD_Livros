
package com.senac.livros.controller;

import com.senac.livros.data.LivroEntity;
import com.senac.livros.service.LivroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davi_
 */
@RestController
@RequestMapping("/livros_biblioteca")
@CrossOrigin(origins = "*")
public class LivroController {
    
    @Autowired
    LivroService service;
    
    @GetMapping("/listar")
    public ResponseEntity<List> buscarTodosLivros(){
        List<LivroEntity> livros = service.buscarTodosLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<LivroEntity> buscarLivro(@PathVariable int id){
        LivroEntity livro = service.buscarLivroID(id);
        return new ResponseEntity<>(livro,HttpStatus.OK);
    }
    
    
    @PostMapping("/cadastrar")
    public ResponseEntity<LivroEntity> cadastrarLivro(@RequestBody LivroEntity livro){
        LivroEntity livroCadastrado = service.cadastrarLivro(livro);
        return new ResponseEntity<>(livroCadastrado, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<LivroEntity> atualizarLivro(@PathVariable int id, @RequestBody LivroEntity livro){
        LivroEntity livroAtualizado = service.atualizarLivro(id, livro);
        return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarLivro(@PathVariable int id){
        service.deletarLivro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/pesquisar-titulo/{texto}")
    public ResponseEntity<List> buscarLivroTextoTitulo(@PathVariable String texto){
        List<LivroEntity> livros = service.buscarTituloContemTexto(texto);
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }
    
    
    @GetMapping("pesquisar/autor/{texto}")
    public ResponseEntity<List> buscarTextoAutor(@PathVariable String texto){
        List<LivroEntity> livros = service.buscarLivroAutorContemTexto(texto);
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }
}
