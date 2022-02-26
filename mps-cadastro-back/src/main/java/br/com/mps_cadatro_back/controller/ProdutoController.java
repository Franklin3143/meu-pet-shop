package br.com.mps_cadatro_back.controller;

import br.com.mps_cadatro_back.model.Produto;
import br.com.mps_cadatro_back.model.dto.ProdutoDto;
import br.com.mps_cadatro_back.repository.ProdutoRepository;
import br.com.mps_cadatro_back.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = {"/{id}"})
    public ResponseEntity <ProdutoDto> buscarProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(new ProdutoDto(produto.get()));
        }
        return ResponseEntity.notFound().build();
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

    @PutMapping("/{id}")
    public ResponseEntity atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto produto) {
        produto.setIdProduto(id);
        ProdutoDto produtoDto = produtoService.update(produto, id);

        return produtoDto != null ?
                ResponseEntity.ok(produtoDto) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto (@PathVariable("id") Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
