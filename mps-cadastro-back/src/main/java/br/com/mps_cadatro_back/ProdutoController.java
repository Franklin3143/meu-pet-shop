package br.com.mps_cadatro_back;

import br.com.mps_cadatro_back.model.Produto;
import br.com.mps_cadatro_back.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }
}
