package com.am.labpadroesprojetospring.api.dto.controller;

import com.am.labpadroesprojetospring.api.dto.request.ClientRequest;
import com.am.labpadroesprojetospring.api.dto.response.ClientResponse;
import com.am.labpadroesprojetospring.api.mapper.ClientMapper;
import com.am.labpadroesprojetospring.domain.entity.Client;
import com.am.labpadroesprojetospring.domain.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar Todos", description = "Listar clientes cadastrados")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "busca realizada com sucesso")
    })
    public ResponseEntity<Set<ClientResponse>> all(){

        return ResponseEntity.ok(
                clientService.all().stream()
                        .map(clientMapper::toClientResponse)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por Identificador", description = "Buscar cliente pelo campo id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "302", description = "cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "cliente não encontrado")
    })
    public ResponseEntity<ClientResponse> byId (@PathVariable("id") Long id){
        final Optional<Client> opClient = clientService.byId(id);

        return  opClient.isPresent()? ResponseEntity.ok().body(clientMapper.toClientResponse(opClient.get())): ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Salvar",description = "Adiciona um cliente")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "cliente criado com sucesso"),
            @ApiResponse(responseCode = "404", description = "cliente não encontrado")
    })
    public ResponseEntity<Client> save (@RequestBody ClientRequest request){
      return ResponseEntity.ok(clientService.save(clientMapper.toClient(request)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Alterar",description = "Alterar um cliente")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "cliente alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "cliente não encontrado")
    })
    public ResponseEntity<Client> update(@RequestBody ClientRequest request, @PathVariable("id") Long id){
        return ResponseEntity.ok(clientService.update(clientMapper.toClient(request), id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar", description = "Deleta cliente pelo campo id")

    @ApiResponses(value={
            @ApiResponse(responseCode = "204", description = "cliente excluido")
    })
    public void delete(@PathVariable("id") long id){
        clientService.deleteById(id);
    }
}
