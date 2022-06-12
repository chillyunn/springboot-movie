package com.kit.movie.domain.user;

import com.kit.movie.domain.reservation.Reservation;
import com.kit.movie.domain.review.Review;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String loginID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "userResv")
    List<Reservation> reservations = new ArrayList<>();

    @Builder
    public User(String loginID,String name, String password, Role role){
        this.loginID=loginID;
        this.name=name;
        this.password = password;
        this.role = role;
    }

//
//
//
//    public String getRoleKey(){
//        return this.role.getKey();
//    }
}
