#include <iostream>
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "Asignatura.h"
#include "Estudiante.h"
#include "Matricula.h"
#include "Curso.h"
#include "OrdenMatricula.h"

using namespace std;


TEST_CASE("Comprobando constructores y métodos get Asignatura", "[Constructores-Get-Asignatura]" ) {
    Asignatura a;
    REQUIRE( a.getNombre() == "" );
    REQUIRE( a.getCreditos() == 0 );
    REQUIRE( a.getPlanEstudios() == 0 );

    Asignatura * a1 = new Asignatura("Pepe",60,801);
    REQUIRE( a1->getNombre() == "Pepe" );
    REQUIRE( a1->getCreditos() == 60 );
    REQUIRE( a1->getPlanEstudios() == 801 );
}


TEST_CASE("Comprobando métodos setNombre y getNombre", "[Nombre-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("Pepe",60,801);
    a1->setNombre("Juan");
    REQUIRE( a1->getNombre() == "Juan" );
}

TEST_CASE("Comprobando métodos setCreditos y getCreditos", "[Creditos-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("Pepe",60,801);
    a1->setCreditos(54);
    REQUIRE( a1->getCreditos() == 54 );
}

TEST_CASE("Comprobando métodos setPlanEstudios y getPlanEstudios", "[PlanEstudios-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("Pepe",60,801);
    a1->setPlanEstudios(701);
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

}

TEST_CASE("Comprobando métodos setFamiliaNumerosa y getFamiliaNumerosa", "[FamiliaNumerosa-Estudiante]" ) {
    Estudiante * e1 = new Estudiante("peperez",true);
    e1->setFamiliaNumerosa(false);
    REQUIRE( e1->getFamiliaNumerosa() == false);
}



TEST_CASE("Comprobando constructores y métodos get Matricula", "[Constructores-Get-Matricula]" ) {

    Asignatura * a1 = new Asignatura("POO",60,801);
    Estudiante * e1 = new Estudiante("peperez",true);



    Matricula * m = new Matricula(a1,e1,C1718,M1);
    REQUIRE( m->getAsignatura()->getNombre() == "POO" );
    REQUIRE( m->getAsignatura()->getCreditos() == 60 );
    REQUIRE( m->getAsignatura()->getPlanEstudios() == 801 );
    REQUIRE( m->getEstudiante()->getCuasi() == "peperez" );
    REQUIRE( m->getEstudiante()->getFamiliaNumerosa() == true);
    REQUIRE( m->getEstudiante()->getFamiliaNumerosa() == true);
    REQUIRE( m->getCurso() == C1718);
    REQUIRE( m->getOrdenMatricula() == M1);

}
