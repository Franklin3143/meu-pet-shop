package br.com.mps_cadatro_back.model.dto;

import br.com.mps_cadatro_back.model.Produto;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ProdutoDto {

    private Long idProduto;
    @NotNull
    private Double valor;
    private Date validade;
    private Enum status;
    private String nomeProduto;
    private Integer quantidadeEstoque;

    public ProdutoDto() {
    }

    public ProdutoDto(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.valor = produto.getValor();
        this.validade = produto.getValidade();
        this.status = produto.getStatus();
        this.nomeProduto = produto.getNomeProduto();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
    }

    public static ProdutoDto create(Produto produto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(produto, ProdutoDto.class);
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
