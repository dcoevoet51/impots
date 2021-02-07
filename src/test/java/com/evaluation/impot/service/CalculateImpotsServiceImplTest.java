package com.evaluation.impot.service;

import com.evaluation.impot.domain.AutoEntreprise;
import com.evaluation.impot.domain.Entreprise;
import com.evaluation.impot.domain.EntrepriseType;
import com.evaluation.impot.domain.SASEntreprise;
import com.evaluation.impot.exception.InvalidCAException;
import com.evaluation.impot.service.impl.CalculateImpotsServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculateImpotsServiceImplTest {

    private CalculateImpotsService calculateImpotsService;
    private Entreprise autoEntreprise;
    private Entreprise sasEntreprise;

    @Before
    public void init() {
        this.calculateImpotsService = new CalculateImpotsServiceImpl();
        this.autoEntreprise = new AutoEntreprise("362 521 879 00034", "AutoEntrepriseDenomination");
        this.sasEntreprise = new SASEntreprise("362 521 879 00034", "AutoEntrepriseDenomination", "2 rue de l'égalité");
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void calculate_impot_for_auto_entreprise_should_work_with_correct_values() {
        Assertions.assertThat(autoEntreprise.getType()).isEqualTo(EntrepriseType.AUTO_ENTREPRISE);

        Double actualResult = calculateImpotsService.calculateImpots(autoEntreprise, 12000d);
        Assertions.assertThat(actualResult).isEqualTo(3000);
    }

    @Test
    public void calculate_impot_for_auto_entreprise_should_work_with_ca_zero() {
        Double actualResult = calculateImpotsService.calculateImpots(autoEntreprise, 0d);
        Assertions.assertThat(actualResult).isEqualTo(0);
    }

    @Test
    public void calculate_impot_for_auto_entreprise_should_work_with_ca_negative() {
        exceptionRule.expect(InvalidCAException.class);
        exceptionRule.expectMessage("Illegal ca with value -1");
        calculateImpotsService.calculateImpots(autoEntreprise, -1d);
    }

    @Test
    public void calculate_impot_for_auto_entreprise_should_work_with_ca_null() {
        exceptionRule.expect(InvalidCAException.class);
        exceptionRule.expectMessage("Illegal ca with value null");
        calculateImpotsService.calculateImpots(autoEntreprise, null);
    }

    @Test
    public void calculate_impot_for_sas_entreprise_should_work_with_correct_values() {
        Assertions.assertThat(sasEntreprise.getType()).isEqualTo(EntrepriseType.SAS);

        Double actualResult = calculateImpotsService.calculateImpots(sasEntreprise, 12000d);
        Assertions.assertThat(actualResult).isEqualTo(3960);
    }

    @Test
    public void calculate_impot_for_sas_entreprise_should_work_with_ca_zero() {
        Double actualResult = calculateImpotsService.calculateImpots(sasEntreprise, 0d);
        Assertions.assertThat(actualResult).isEqualTo(0);
    }

    @Test
    public void calculate_impot_for_sas_entreprise_should_work_with_ca_negative() {
        exceptionRule.expect(InvalidCAException.class);
        exceptionRule.expectMessage("Illegal ca with value -1");
        calculateImpotsService.calculateImpots(sasEntreprise, -1d);
    }

    @Test
    public void calculate_impot_for_sas_entreprise_should_work_with_ca_null() {
        exceptionRule.expect(InvalidCAException.class);
        exceptionRule.expectMessage("Illegal ca with value null");
        calculateImpotsService.calculateImpots(sasEntreprise, null);
    }
}