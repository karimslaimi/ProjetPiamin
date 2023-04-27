package com.esprit.projetpi.Services;

import com.esprit.projetpi.Entities.Candidature;

import java.time.LocalDateTime;
import java.util.List;

public interface IServiceCandidature {

    public Candidature postC(Candidature candidature);

    public List<Candidature>allCandidature();
    public List<Candidature>filterByState(String filter);

    public Candidature updateCandidate(int idc,String state);

}
