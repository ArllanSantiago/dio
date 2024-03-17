package com.am.labpadroesprojetospring.api.dto.response;

import com.am.labpadroesprojetospring.domain.entity.Address;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ClientResponse {

    private String name;
    private Address  address;


}
