package com.evaluation.impot.service.impl;

import com.evaluation.impot.domain.Entreprise;
import com.evaluation.impot.exception.InvalidCAException;
import com.evaluation.impot.service.CalculateImpotsService;

public class CalculateImpotsServiceImpl implements CalculateImpotsService {

    public Double calculateImpots(Entreprise entreprise, Double ca) {
        if (ca == null || ca < 0) {
            throw new InvalidCAException(String.format("Illegal ca with value %s", ca));
        }
        return entreprise.getTauxImposition() * ca;
    }
}