package br.com.mps_cadatro_back.service;

import br.com.mps_cadatro_back.model.Produto;
import br.com.mps_cadatro_back.model.dto.ProdutoDto;
import br.com.mps_cadatro_back.repository.ProdutoRepository;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDto insert(Produto produto) {
        return ProdutoDto.create(produtoRepository.save(produto));
    }

    public ProdutoDto update(Produto produto, Long id) {
        Assert.notNull(produto.getIdProduto(), "Não foi possível atualizar produto");

        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto db = optionalProduto.get();
            db.setIdProduto(produto.getIdProduto());
            db.setNomeProduto(produto.getNomeProduto());
            db.setQuantidadeEstoque(produto.getQuantidadeEstoque());
            db.setStatus(produto.getStatus());
            db.setValidade(produto.getValidade());
            db.setValor(produto.getValor());

            produtoRepository.save(db);

            return ProdutoDto.create(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar registro de produto após a inserção de dados");
        }
    }

    public void delete(Long id) { produtoRepository.deleteById(id);}
}
