package br.com.mps_cadatro_back.controller;

import br.com.mps_cadatro_back.model.Produto;
import br.com.mps_cadatro_back.model.dto.ProdutoDto;
import br.com.mps_cadatro_back.repository.ProdutoRepository;
import br.com.mps_cadatro_back.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    @PostMapping
    public ResponseEntity cadastrarNovoProduto(@RequestBody Produto produto ) {
        ProdutoDto produtoDto = produtoService.insert(produto);
        URI uri = getUri(produtoDto.getIdProduto());
        return ResponseEntity.created(uri).build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}
