package school.sptech.democonexaoapiexterna.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import school.sptech.democonexaoapiexterna.dto.BancoApiMockDto;
import school.sptech.democonexaoapiexterna.dto.BancoMockDto;
import school.sptech.democonexaoapiexterna.comandos.Ordenacao;
import school.sptech.democonexaoapiexterna.dto.SomaDiasResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itens")
public class ItemMockController {

    @GetMapping
    @Operation(summary = "Listar itens da API mock")
    public ResponseEntity<List<BancoMockDto>> listItens() {
        List<BancoMockDto> resposta = getBancoMockDtoList();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/data-vencimento")
    @Operation(summary = "Listar itens da API mock Ordenados")
    public ResponseEntity<BancoMockDto[]> listaDataVencimento() {
        BancoMockDto[] respostaOrdenada = getBancoMockDtoArray();
        Ordenacao.mergeSort(respostaOrdenada);
        return ResponseEntity.ok(respostaOrdenada);
    }

    @GetMapping("/conversao-padrao")
    @Operation(summary = "Listar itens da API mock Ordenados")
    public ResponseEntity<BancoMockDto[]> listaConversao() {
        BancoMockDto[] respostaOrdenada = getBancoMockDtoArray();
        Ordenacao.quickSort(respostaOrdenada);
        return ResponseEntity.ok(respostaOrdenada);
    }

    @GetMapping("/soma/{num}")
    public ResponseEntity<SomaDiasResponse> somaDias(@PathVariable int num) {
        BancoMockDto[] respostaOrdenada = getBancoMockDtoArray();
        int soma = Ordenacao.calcularSomaRecursiva(respostaOrdenada, num);
        SomaDiasResponse response = new SomaDiasResponse(soma);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/conversao-padrao/{id}")
    @Operation(summary = "Listar itens da API mock Ordenados")
    public ResponseEntity<BancoMockDto> listaConversaoBinaria(@PathVariable int id) {
        BancoMockDto[] respostaOrdenada = getBancoMockDtoArray();
        int indice = Ordenacao.pesquisaBinaria(respostaOrdenada, id);

        if (indice != -1) {
            return ResponseEntity.ok(respostaOrdenada[indice]);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
    }

    private List<BancoMockDto> getBancoMockDtoList() {
        RestClient client = RestClient.builder()
                .baseUrl("https://66270d4db625bf088c0737c3.mockapi.io/itens")
                .messageConverters(httpMessageConverters -> httpMessageConverters.add(new MappingJackson2HttpMessageConverter()))
                .build();

        List<BancoApiMockDto> mockApi = client.get()
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

        return mockApi.stream().map(item -> {
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
    }

    private BancoMockDto[] getBancoMockDtoArray() {
        List<BancoMockDto> resposta = getBancoMockDtoList();
        return resposta.toArray(new BancoMockDto[0]);
    }
}
