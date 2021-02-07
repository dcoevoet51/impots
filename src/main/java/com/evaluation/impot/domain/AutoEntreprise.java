package com.evaluation.impot.domain;

public class AutoEntreprise extends Entreprise {

    public AutoEntreprise(String siret, String denomination) {
        super(siret, denomination, EntrepriseType.AUTO_ENTREPRISE);
    }

    @Override
    public Double getTauxImposition() {
        return 0.25;
    }
}