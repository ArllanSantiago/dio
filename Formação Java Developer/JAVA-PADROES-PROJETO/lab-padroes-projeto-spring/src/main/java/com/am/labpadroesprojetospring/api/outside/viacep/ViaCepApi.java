package com.am.labpadroesprojetospring.api.outside.viacep;

import com.am.labpadroesprojetospring.domain.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="viacep", url = "https://viacep.com.br/ws")
public interface ViaCepApi {
    @GetMapping("/{zip}/json/")
    Address consultarCep(@PathVariable("zip") String zip);
}
