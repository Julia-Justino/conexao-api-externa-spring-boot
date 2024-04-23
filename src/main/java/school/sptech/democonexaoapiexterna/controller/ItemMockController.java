package school.sptech.democonexaoapiexterna.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import school.sptech.democonexaoapiexterna.dto.BancoApiMockDto;
import school.sptech.democonexaoapiexterna.dto.BancoMockDto;

import java.util.List;
import java.util.stream.Collectors;

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
                    bancoDto.setConversaoPadrao(item.getConversaoPadrao());
                    bancoDto.setDiasVencimento(item.getDiasVencimento());
                    bancoDto.setPerecivel(item.getPerecivel());
                    bancoDto.setNomeCategoria(item.getNomeCategoria());
                    bancoDto.setUnidadeMedida(item.getUnidadeMedida());
                    return bancoDto;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(resposta);
    }
}
