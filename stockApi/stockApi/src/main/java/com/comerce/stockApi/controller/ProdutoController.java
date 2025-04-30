package com.comerce.stockApi.controller;

import com.comerce.stockApi.dto.ProdutoAtualizarDto;
import com.comerce.stockApi.dto.ProdutoRegistroDto;
import com.comerce.stockApi.dto.ProdutoRespostaDto;
import com.comerce.stockApi.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Validated // Essencal para permitir a utilização automática de valids em pathVariables
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoRespostaDto> registrarProduto(@RequestBody @Valid ProdutoRegistroDto produto) {
        ProdutoRespostaDto responseBody = produtoService.registrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable @Positive int id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDto> buscarProduto(@PathVariable @Positive int id){
        ProdutoRespostaDto produto = produtoService.buscarProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }
            
    @GetMapping
    public ResponseEntity<List<ProdutoRespostaDto>> listarProdutos(){
        List<ProdutoRespostaDto> produtos = produtoService.listarProdutos();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDto> atualizarProduto(@PathVariable @Positive int id, @RequestBody ProdutoAtualizarDto produto){
        ProdutoRespostaDto responseBody = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    

    /*
 Códigos de Status HTTP mais comuns:

 1xx - Informativo:
    100 Continue: O servidor recebeu a solicitação inicial e o cliente pode continuar.

 2xx - Sucesso:
    200 OK: Requisição bem-sucedida.
    201 Created: Recurso criado com sucesso.
    202 Accepted: Requisição aceita para processamento (ainda não concluído).
    204 No Content: Sucesso sem conteúdo no corpo da resposta.

 3xx - Redirecionamento:
    301 Moved Permanently: URL movida permanentemente.
    302 Found: URL movida temporariamente.
    304 Not Modified: Conteúdo não modificado (usar cache).

 4xx - Erro do cliente:
    400 Bad Request: Erro na requisição enviada pelo cliente.
    401 Unauthorized: Falta autenticação.
    403 Forbidden: Acesso proibido, mesmo autenticado.
    404 Not Found: Recurso não encontrado.
    405 Method Not Allowed: Método HTTP não permitido.
    409 Conflict: Conflito de dados (ex: tentativa de cadastro duplicado).
    415 Unsupported Media Type: Tipo de conteúdo inválido.
    422 Unprocessable Entity: Dados enviados inválidos (erros de validação).
    429 Too Many Requests: Muitas requisições em pouco tempo.

 5xx - Erro do servidor:
    500 Internal Server Error: Erro interno do servidor.
    502 Bad Gateway: Comunicação falha entre servidores.
    503 Service Unavailable: Serviço temporariamente indisponível.
    504 Gateway Timeout: Servidor demorou demais para responder.

 Observação:
 - 2xx indica sucesso
 - 4xx indica erro do cliente
 - 5xx indica erro do servidor
     */
    
    
// === Validações para campos de texto (String) ===

// @NotNull: Garante que o valor não seja nulo (mas pode ser vazio "")
// @NotBlank: Garante que o texto não seja nulo, vazio, ou só espaços
// @NotEmpty: Garante que o texto não seja nulo nem vazio ("")
// @Size(min = x, max = y): Define o tamanho mínimo e máximo do texto
// @Pattern(regexp = "regex"): Valida o formato do texto usando uma expressão regular

// === Validações para números (int, long, float, double) ===

// @Positive: Número deve ser positivo (> 0)
// @PositiveOrZero: Número deve ser positivo ou zero (>= 0)
// @Negative: Número deve ser negativo (< 0)
// @NegativeOrZero: Número deve ser negativo ou zero (<= 0)
// @Min(value = x): Número deve ser maior ou igual a x
// @Max(value = y): Número deve ser menor ou igual a y
// @Digits(integer = x, fraction = y): Define a quantidade máxima de dígitos inteiros e decimais

// === Validações para coleções (List, Set, Map, Array) ===

// @NotEmpty: A coleção não pode ser nula nem vazia
// @Size(min = x, max = y): Define quantidade mínima e máxima de elementos na coleção

// === Validações específicas ===

// @Email: Valida se o texto é um e-mail válido
// @Past: Data deve ser no passado
// @PastOrPresent: Data deve ser no passado ou hoje
// @Future: Data deve ser no futuro
// @FutureOrPresent: Data deve ser no futuro ou hoje
// @AssertTrue: O valor boolean deve ser true
// @AssertFalse: O valor boolean deve ser false

// === Extras (avançados) ===

// @Valid: Indica que o objeto também deve ser validado (útil para validar objetos internos)
// @Null: Garante que o valor seja nulo (raro de usar)
}
