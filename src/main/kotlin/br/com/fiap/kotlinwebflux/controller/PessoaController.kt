package br.com.fiap.kotlinwebflux.controller

import br.com.fiap.kotlinwebflux.dto.PessoaDTO
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
class PessoaController {
    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getPessoas(): Flux<PessoaDTO> = Flux.just(
            arrayListOf<PessoaDTO>(
                PessoaDTO(id = 1, cpf = "123", nome = "Jesus"),
                PessoaDTO(id = 2, cpf = "321", nome = "Maria"),
                PessoaDTO(id = 3, cpf = "213", nome = "José")
            )
    ).flatMapIterable { it }
            .delayElements(Duration.ofSeconds(3))
}

//    fun getPessoas(): Flux<PessoaDTO> = Flux.create { emmiter ->
//        emmiter.next(PessoaDTO(id = 1, cpf = "123", nome = "Jesus"))
//        emmiter.next(PessoaDTO(id = 2, cpf = "321", nome = "Maria"))
//        emmiter.next(PessoaDTO(id = 3, cpf = "213", nome = "José"))
//        emmiter.complete()
//    }
