package br.com.robson.pocsecurity.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.pocsecurity.transportlayers.api.ClientesApi;
import br.com.robson.pocsecurity.transportlayers.model.Cliente;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping
@PreAuthorize("hasAnyRole('ADMIN')")
public class ClienteController implements ClientesApi{

    public ResponseEntity<Cliente> clientesPost(@RequestHeader(value="Authorization", required=false) String authorization, @Valid @RequestBody(required = false) Cliente cliente) {

        return ResponseEntity.ok(cliente);

    }
	
}
