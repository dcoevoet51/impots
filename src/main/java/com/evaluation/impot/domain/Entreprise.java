package com.evaluation.impot.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entreprise {

    private final Siret siret;
    private final String denomination;
    private final EntrepriseType type;

    public Entreprise(String siret, String denomination, EntrepriseType type) {
        this.siret = new Siret(siret);
        this.denomination = denomination;
        this.type = type;
    }

    /**
     * Taux d'imposition spécifique à chaque type d'entreprise
     * @return taux
     */
    public abstract Double getTauxImposition();


}