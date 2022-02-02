package br.com.mps_cadatro_back.service;

import br.com.mps_cadatro_back.model.Produto;
import br.com.mps_cadatro_back.model.dto.ProdutoDto;
import br.com.mps_cadatro_back.repository.ProdutoRepository;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDto insert(Produto produto) {
        Assert.isNull(produto.getIdProduto(), "Não foi possível inserir novo Produto");
        return ProdutoDto.create(produtoRepository.save(produto));
    }
}
