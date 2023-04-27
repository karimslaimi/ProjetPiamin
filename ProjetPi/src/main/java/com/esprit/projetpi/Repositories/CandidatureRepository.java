package com.esprit.projetpi.Repositories;

import com.esprit.projetpi.Entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {



    @Query("select c from Candidature c where c.state=:state")
    public List<Candidature> filterByState(@Param("state") String state);


}
