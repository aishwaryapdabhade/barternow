package com.acrux.barternow;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.acrux.barternow");

        noClasses()
            .that()
                .resideInAnyPackage("com.acrux.barternow.service..")
            .or()
                .resideInAnyPackage("com.acrux.barternow.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.acrux.barternow.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
