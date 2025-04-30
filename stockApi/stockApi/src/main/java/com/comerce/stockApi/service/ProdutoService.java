package com.comerce.stockApi.service;

import com.comerce.stockApi.dto.ProdutoAtualizarDto;
import com.comerce.stockApi.dto.ProdutoRegistroDto;
import com.comerce.stockApi.dto.ProdutoRespostaDto;
import com.comerce.stockApi.exceptions.InvalidDataException;
import com.comerce.stockApi.exceptions.NoProductsRegisteredException;
import com.comerce.stockApi.exceptions.ProductNotFoundException;
import com.comerce.stockApi.model.Produto;
import com.comerce.stockApi.repository.ProdutoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoRespostaDto registrarProduto(ProdutoRegistroDto produtoDto) {
        Produto produto = new Produto(
                produtoDto.nome(),
                produtoDto.preco());
        Produto produtoCriado = produtoRepository.save(produto);

        return new ProdutoRespostaDto(
                produtoCriado.getId(),
                produtoCriado.getNome(),
                produtoCriado.getPreco());
    }

    public void deletarProduto(int id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            throw new ProductNotFoundException();
        }

        produtoRepository.delete(produto.get());

    }

    public List<ProdutoRespostaDto> listarProdutos() {
        Iterable<Produto> produtos = produtoRepository.findAll();

        List<ProdutoRespostaDto> resposta = new ArrayList();

        for (Produto produto : produtos) {
            ProdutoRespostaDto produtoResposta = new ProdutoRespostaDto(
                    produto.getId(),
                    produto.getNome(),
                    produto.getPreco()
            );
            resposta.add(produtoResposta);
        }

        if (resposta.isEmpty()) {
            throw new NoProductsRegisteredException();
        }

        return resposta;
    }

    public ProdutoRespostaDto buscarProduto(int id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Produto produtoEncontrado = produto.get();

        return new ProdutoRespostaDto(
                produtoEncontrado.getId(),
                produtoEncontrado.getNome(),
                produtoEncontrado.getPreco()
        );
    }

    public ProdutoRespostaDto atualizarProduto(int id, ProdutoAtualizarDto dadosAtualizados) {

        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Produto produtoParaAtualizar = produto.get();

        if (!dadosAtualizados.nome().trim().isBlank()) {
            produtoParaAtualizar.setNome(dadosAtualizados.nome());
        }
        if(dadosAtualizados.preco() != null){
            if (dadosAtualizados.preco() <= 0){
                throw new InvalidDataException();
            }
            produtoParaAtualizar.setPreco(dadosAtualizados.preco());
        }
        
        Produto produtoAtualizado = produtoRepository.save(produtoParaAtualizar);
        
        return new ProdutoRespostaDto(
                produtoAtualizado.getId(),
                produtoAtualizado.getNome(),
                produtoAtualizado.getPreco()
        );
    }

}
