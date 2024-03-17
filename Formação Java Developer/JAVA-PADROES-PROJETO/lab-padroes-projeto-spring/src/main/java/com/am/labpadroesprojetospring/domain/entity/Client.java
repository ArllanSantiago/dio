package com.am.labpadroesprojetospring.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;


@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @Setter(AccessLevel.PUBLIC)
    private Address address;

    public void updateId(long id){
        if (this.id > 0) throw new IllegalArgumentException("Client already has Id");
        setId(id);

    }
}
