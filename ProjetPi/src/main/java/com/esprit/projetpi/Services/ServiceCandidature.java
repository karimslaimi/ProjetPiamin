package com.esprit.projetpi.Services;

import com.esprit.projetpi.Entities.Candidature;
import com.esprit.projetpi.Repositories.CandidatureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServiceCandidature implements IServiceCandidature {

    private CandidatureRepository candidatureRepository;


    public ServiceCandidature(CandidatureRepository candidatureRepository) {
        this.candidatureRepository = candidatureRepository;
    }


    @Override
    public Candidature postC(Candidature candidature) {


        candidature.setDate(LocalDateTime.now());
        candidature.setState("ON HOLD");
        return candidatureRepository.save(candidature);

    }

    @Override
    public List<Candidature> allCandidature() {
        return candidatureRepository.findAll();
    }

    @Override
    public List<Candidature> filterByState(String filter) {
        return candidatureRepository.filterByState(filter);
    }


    @Override
    public Candidature updateCandidate(int idc, String state) {
        Candidature candidature = candidatureRepository.findById(idc).orElse(null);
        if (candidature == null) {
            return null;
        } else {
            candidature.setState(state);
            return candidatureRepository.save(candidature);
        }
    }
}
