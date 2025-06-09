package com.api.cinema.domain.repository;

import com.api.cinema.domain.model.Movie;
import com.api.cinema.domain.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query("from Session s join fetch s.movie join fetch s.room")
    List<Session> findAll();
    List<Session> findByMovieAndStartTimeAfterOrderByStartTime(Movie movie, LocalDateTime now);
}
