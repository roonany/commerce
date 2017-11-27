package com.rsupport.commerce.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = {"orders", "cart"})
@Setter
@Getter
//public class User extends AbstractEntity<Long> {
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_authority",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")}
    )
    private Set<Authority> authorities = new HashSet<>();

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        this.authorities.forEach(
                authority -> authorities.add(authority));
        return authorities;
    }

//    public Set<GrantedAuthority> getAuthorities() {
//        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
//        for (Authority authority : this.authorities) {
//            authorities.add(authority);
//        }
//        return authorities;
//    }
}