package com.kit.movie.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReviewRepository {
    @PersistenceContext
    EntityManager em;

    public void save(Review review){
        if(review.getId() == null){
            em.persist(review);
        }else{
            em.merge(review);
        }
    }

    public Review findOne(Long id){
        return em.find(Review.class, id);
    }
    public List<Review> findAll() {
        return em.createQuery("select i from Review i",Review.class)
                .getResultList();
    }
}
