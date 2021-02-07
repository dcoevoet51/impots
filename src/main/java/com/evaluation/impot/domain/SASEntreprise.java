package com.evaluation.impot.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SASEntreprise extends Entreprise {

    private final String address;

    public SASEntreprise(String siret, String denomination, String address) {
        super(siret, denomination, EntrepriseType.SAS);
        this.address = address;
    }

    @Override
    public Double getTauxImposition() {
        return 0.33;
    }
}