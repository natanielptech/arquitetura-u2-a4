package br.com.aula.clean.architecture;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class CleanArchitectureTest {

    @Test
    void camadasInternasNaoDependemDeFrameworks() {
        ArchRule rule = noClasses().that().resideInAnyPackage("..entities..", "..usecases..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("org.springframework..", "jakarta.persistence..");

        rule.check(new ClassFileImporter().importPackages("br.com.aula.clean"));
    }
}
