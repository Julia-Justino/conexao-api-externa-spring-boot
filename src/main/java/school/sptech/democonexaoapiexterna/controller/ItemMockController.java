package school.sptech.democonexaoapiexterna.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import school.sptech.democonexaoapiexterna.comandos.Ordenacao;
import school.sptech.democonexaoapiexterna.dto.BancoApiMockDto;
import school.sptech.democonexaoapiexterna.dto.BancoMockDto;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static school.sptech.democonexaoapiexterna.comandos.Ordenacao.*;

@RestController
@RequestMapping("/itens")
public class ItemMockController {
    private static final Logger log = LoggerFactory.getLogger(ItemMockController.class);

    @GetMapping
    @Operation(summary = "Listar itens da API mock")
    public ResponseEntity<List<BancoMockDto>> listItens() {
        RestClient client = RestClient.builder()
                .baseUrl("https://66270d4db625bf088c0737c3.mockapi.io/itens")
                .messageConverters(httpMessageConverters -> httpMessageConverters.add(new MappingJackson2HttpMessageConverter()))
                .build();

        List<BancoApiMockDto> mockApi = client.get()
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        List<BancoMockDto> resposta =
                mockApi.stream().map(item -> {
                    BancoMockDto bancoDto = new BancoMockDto();
                    bancoDto.setId(item.getId());
                    bancoDto.setNome(item.getNome());
                    bancoDto.setConversaoPadrao(item.getConversaoPadrao());
                    bancoDto.setDiasVencimento(item.getDiasVencimento());
                    bancoDto.setPerecivel(item.isPerecivel());
                    bancoDto.setNomeCategoria(item.getNomeCategoria());
                    bancoDto.setUnidadeMedida(item.getUnidadeMedida());
                    return bancoDto;
                }).collect(Collectors.toList());


        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/data-vencimento")
    @Operation(summary = "Listar itens da API mock Ordenados")
    public ResponseEntity <BancoMockDto[]> listaDataVencimento() {
        RestClient client = RestClient.builder()
                .baseUrl("https://66270d4db625bf088c0737c3.mockapi.io/itens")
                .messageConverters(httpMessageConverters -> httpMessageConverters.add(new MappingJackson2HttpMessageConverter()))
                .build();

        List<BancoApiMockDto> mockApi = client.get()
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        List<BancoMockDto> resposta =
                mockApi.stream().map(item -> {
                    BancoMockDto bancoDto = new BancoMockDto();
                    bancoDto.setId(item.getId());
                    bancoDto.setNome(item.getNome());
                    bancoDto.setConversaoPadrao(item.getConversaoPadrao());
                    bancoDto.setDiasVencimento(item.getDiasVencimento());
                    bancoDto.setPerecivel(item.isPerecivel());
                    bancoDto.setNomeCategoria(item.getNomeCategoria());
                    bancoDto.setUnidadeMedida(item.getUnidadeMedida());
                    return bancoDto;
                }).collect(Collectors.toList());

        //BancoMockDto[] arr = (BancoMockDto[]) resposta.toArray();
        BancoMockDto[] arr = resposta.toArray(new BancoMockDto[0]);
        mergeSort(arr);
        return ResponseEntity.ok(arr);
    }

    @GetMapping("/conversao-padrao")
    @Operation(summary = "Listar itens da API mock Ordenados")
    public ResponseEntity <BancoMockDto[]> listaConversao() {
        RestClient client = RestClient.builder()
                .baseUrl("https://66270d4db625bf088c0737c3.mockapi.io/itens")
                .messageConverters(httpMessageConverters -> httpMessageConverters.add(new MappingJackson2HttpMessageConverter()))
                .build();

        List<BancoApiMockDto> mockApi = client.get()
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        List<BancoMockDto> resposta =
                mockApi.stream().map(item -> {
                    BancoMockDto bancoDto = new BancoMockDto();
                    bancoDto.setId(item.getId());
                    bancoDto.setNome(item.getNome());
                    bancoDto.setConversaoPadrao(item.getConversaoPadrao());
                    bancoDto.setDiasVencimento(item.getDiasVencimento());
                    bancoDto.setPerecivel(item.isPerecivel());
                    bancoDto.setNomeCategoria(item.getNomeCategoria());
                    bancoDto.setUnidadeMedida(item.getUnidadeMedida());
                    return bancoDto;
                }).collect(Collectors.toList());

        //BancoMockDto[] arr = (BancoMockDto[]) resposta.toArray();
        BancoMockDto[] arr = resposta.toArray(new BancoMockDto[0]);
        quickSort(arr);
        return ResponseEntity.ok(arr);
    }

    @GetMapping("/conversao-padrao/{id}")
    @Operation(summary = "Listar itens da API mock Ordenados")
    public ResponseEntity<BancoMockDto> listaConversaoBinaria(@PathVariable int id) {
        RestClient client = RestClient.builder()
                .baseUrl("https://66270d4db625bf088c0737c3.mockapi.io/itens")
                .messageConverters(httpMessageConverters -> httpMessageConverters.add(new MappingJackson2HttpMessageConverter()))
                .build();

        List<BancoApiMockDto> mockApi = client.get()
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

        List<BancoMockDto> resposta =
                mockApi.stream().map(item -> {
                    BancoMockDto bancoDto = new BancoMockDto();
                    bancoDto.setId(item.getId());
                    bancoDto.setNome(item.getNome());
                    bancoDto.setConversaoPadrao(item.getConversaoPadrao());
                    bancoDto.setDiasVencimento(item.getDiasVencimento());
                    bancoDto.setPerecivel(item.isPerecivel());
                    bancoDto.setNomeCategoria(item.getNomeCategoria());
                    bancoDto.setUnidadeMedida(item.getUnidadeMedida());
                    return bancoDto;
                }).collect(Collectors.toList());

        BancoMockDto[] arr = resposta.toArray(new BancoMockDto[0]);
        mergeSort(arr);
        int indice = pesquisaBinaria(arr, id);

        if (indice != -1) {
            return ResponseEntity.ok(arr[indice]);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
    }

}
