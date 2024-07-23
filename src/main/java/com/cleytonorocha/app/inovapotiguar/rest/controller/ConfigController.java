package com.cleytonorocha.app.inovapotiguar.rest.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleytonorocha.app.inovapotiguar.model.Enum.ProcessoEmpreendedor;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("config")
public class ConfigController {
    @GetMapping("processoLista")
    public List<String> getProcessoList() {
        return Stream.of(ProcessoEmpreendedor.values())
                .map(ProcessoEmpreendedor::name)
                .toList();
    }

}
