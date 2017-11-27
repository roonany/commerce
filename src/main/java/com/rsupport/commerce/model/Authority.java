package com.rsupport.commerce.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "t_authority")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 30)
    private String authority;
}