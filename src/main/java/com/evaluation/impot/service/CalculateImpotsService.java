package com.evaluation.impot.service;

import com.evaluation.impot.domain.Entreprise;

public interface CalculateImpotsService {

    /**
     * Calculer le montant des impôts
     *
     * @param entreprise entreprise
     * @param ca         chiffre d'affaire
     * @return montant des impots
     */
    Double calculateImpots(Entreprise entreprise, Double ca);
}