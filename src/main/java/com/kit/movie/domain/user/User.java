package com.kit.movie.domain.user;

import com.kit.movie.domain.review.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    List<Review> reviews = new ArrayList<>();

    @Builder
    public User(Long id, String name, String password, Role role){
        this.id= id;
        this.name=name;
        this.password = password;
        this.role=role;
    }
//
//
//
//    public String getRoleKey(){
//        return this.role.getKey();
//    }
}
