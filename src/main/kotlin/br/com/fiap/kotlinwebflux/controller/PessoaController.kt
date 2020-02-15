package br.com.fiap.kotlinwebflux.controller

import br.com.fiap.kotlinwebflux.dto.PessoaDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PessoaController{
    @GetMapping
    fun getPessoas(): List<PessoaDTO> = arrayListOf(
                PessoaDTO(id = 1, cpf = "123", nome = "Jesus"),
                PessoaDTO(id = 2, cpf = "321", nome = "Maria"),
                PessoaDTO(id = 3, cpf = "213", nome = "José")
    )
}