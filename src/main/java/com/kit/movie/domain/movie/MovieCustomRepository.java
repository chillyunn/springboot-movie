//package com.kit.movie.domain.movie;
//
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Repository
//public class MovieCustomRepository {
//
//    @PersistenceContext
//    EntityManager em;
//
//    public List<Movie> findMovieWithNameActor(String title, String actor){
//        QMovie movie = QMovie.movie;
//
//        JPAQueryFactory query = new JPAQueryFactory(em);
//
//        return query
//                .selectFrom(movie)
//                .where(titleContains(title),
//                    actorContains(actor)
//                ).fetch();
//
//
//    }
//
//    BooleanExpression titleContains(String title){
//        if(title ==null || title.isEmpty()){
//            return null;
//        }
//        return QMovie.movie.name.contains(title);
//    }
//
//    BooleanExpression actorContains(String actor){
//        if(actor == null || actor.isEmpty()){
//            return null;
//        }
//        return QMovie.movie.actor.contains(actor);
//    }
//}
