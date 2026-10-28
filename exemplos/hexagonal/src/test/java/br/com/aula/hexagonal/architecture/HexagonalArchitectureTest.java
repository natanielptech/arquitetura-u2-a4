package br.com.aula.hexagonal.architecture;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class HexagonalArchitectureTest {

    @Test
    void nucleoNaoDependeDeFrameworks() {
        ArchRule rule = noClasses().that().resideInAnyPackage("..domain..", "..application..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("org.springframework..", "jakarta.persistence..");

        rule.check(new ClassFileImporter().importPackages("br.com.aula.hexagonal"));
    }
}
