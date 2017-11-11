#include <iostream>
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "Asignatura.h"
#include "Estudiante.h"

using namespace std;


TEST_CASE("Comprobando constructores y métodos get Asignatura", "[Constructores-Get-Asignatura]" ) {
    Asignatura a;
    REQUIRE( a.getNombre() == "" );
    REQUIRE( a.getCreditos() == 0 );
    REQUIRE( a.getPlanEstudios() == 0 );

    Asignatura * a1 = new Asignatura("POO",6,801);
    REQUIRE( a1->getNombre() == "POO" );
    REQUIRE( a1->getCreditos() == 6 );
    REQUIRE( a1->getPlanEstudios() == 801 );
}


TEST_CASE("Comprobando métodos setNombre y getNombre", "[Nombre-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("POO",6,801);
    a1->setNombre("TP");
    REQUIRE( a1->getNombre() == "TP" );
    REQUIRE( a1->getCreditos() == 6 );
    REQUIRE( a1->getPlanEstudios() == 801 );
}

TEST_CASE("Comprobando métodos setCreditos y getCreditos", "[Creditos-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("POO",6,801);
    a1->setCreditos(9);
    REQUIRE( a1->getCreditos() == 9 );
    REQUIRE( a1->getNombre() == "POO" );
    REQUIRE( a1->getPlanEstudios() == 801 );
}

TEST_CASE("Comprobando métodos setPlanEstudios y getPlanEstudios", "[PlanEstudios-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("POO",6,801);
    a1->setPlanEstudios(701);
    REQUIRE( a1->getCreditos() == 6 );
    REQUIRE( a1->getNombre() == "POO" );
    REQUIRE( a1->getPlanEstudios() == 701 );
}


TEST_CASE("Comprobando constructores y métodos get Estudiante", "[Constructores-Get-Estudiante]" ) {
    Estudiante e;
    REQUIRE( e.getCuasi() == "" );
    REQUIRE( e.getFamiliaNumerosa() == false);

    Estudiante * e1 = new Estudiante("peperez",true);
    REQUIRE( e1->getCuasi() == "peperez" );
    REQUIRE( e1->getFamiliaNumerosa() == true);
}


TEST_CASE("Comprobando métodos setCUASI y getCUASI", "[CUASI-Estudiante]" ) {
    Estudiante * e1 = new Estudiante("peperez",true);
    e1->setCuasi("pepeperez");
    REQUIRE( e1->getCuasi() == "pepeperez" );
    REQUIRE( e1->getFamiliaNumerosa() == true);

}

TEST_CASE("Comprobando métodos setFamiliaNumerosa y getFamiliaNumerosa", "[FamiliaNumerosa-Estudiante]" ) {
    Estudiante * e1 = new Estudiante("peperez",true);
    e1->setFamiliaNumerosa(false);
    REQUIRE( e1->getCuasi() == "peperez" );
    REQUIRE( e1->getFamiliaNumerosa() == false);
}
