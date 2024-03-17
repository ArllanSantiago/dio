package com.am.labpadroesprojetospring.api.dto.request;

import lombok.Getter;

@Getter
public class ClientRequest {

    private String name;
    private String zipCode;
    private Integer number;
    private String complement;
}
