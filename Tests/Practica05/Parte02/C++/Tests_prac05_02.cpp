#include <iostream>
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "Matricula.h"
#include "Asignatura.h"
#include "Actividad.h"
#include "Reconocimiento.h"
#include "Tipo.h"

using namespace std;


TEST_CASE("Comprobando constructores y métodos get Actividad", "[Constructores-Get-Actividad]" ) {
    Actividad a;
    REQUIRE( a.getNombre() == "" );
    REQUIRE( a.getCreditos() == 0 );

    Actividad * a1 = new Actividad("Pepe",60);
    REQUIRE( a1->getNombre() == "Pepe" );
    REQUIRE( a1->getCreditos() == 60 );
}


TEST_CASE("Comprobando métodos setNombre y getNombre Actividad", "[Nombre-Actividad]" ) {
    Actividad * a1 = new Actividad("Pepe",60);
    a1->setNombre("Juan");
    REQUIRE( a1->getNombre() == "Juan" );
}

TEST_CASE("Comprobando métodos setCreditos y getCreditos Actividad", "[Creditos-Actividad]" ) {
    Actividad * a1 = new Actividad("Pepe",60);
    a1->setCreditos(54);
    REQUIRE( a1->getCreditos() == 54 );
}



TEST_CASE("Comprobando constructores y métodos get Asignatura", "[Constructores-Get-Asignatura]" ) {
    Asignatura a;
    REQUIRE( a.getNombre() == "" );
    REQUIRE( a.getCreditos() == 0 );
    REQUIRE( a.getPlanEstudios() == 0 );

    Asignatura * a1 = new Asignatura("Pepe",60,801,Troncal);
    REQUIRE( a1->getNombre() == "Pepe" );
    REQUIRE( a1->getCreditos() == 60 );
    REQUIRE( a1->getPlanEstudios() == 801 );
    REQUIRE( a1->getTipo() == Troncal );
}


TEST_CASE("Comprobando métodos setNombre y getNombre", "[Nombre-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("Pepe",60,801,Troncal);
    a1->setNombre("Juan");
    REQUIRE( a1->getNombre() == "Juan" );
}

TEST_CASE("Comprobando métodos setCreditos y getCreditos", "[Creditos-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("Pepe",60,801,Troncal);
    a1->setCreditos(54);
    REQUIRE( a1->getCreditos() == 54 );
}

TEST_CASE("Comprobando métodos setPlanEstudios y getPlanEstudios", "[PlanEstudios-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("Pepe",60,801,Troncal);
    a1->setPlanEstudios(701);
    REQUIRE( a1->getPlanEstudios() == 701 );
}


TEST_CASE("Comprobando métodos setTipo y getTipo", "[Tipo-Asignatura]" ) {
    Asignatura * a1 = new Asignatura("Pepe",60,801,Troncal);
    a1->setTipo(Obligatoria);
    REQUIRE( a1->getTipo() == Obligatoria );
    a1->setTipo(Optativa);
    REQUIRE( a1->getTipo() == Optativa );
}


TEST_CASE("Comprobando constructores y métodos get Reconocimiento", "[Constructores-Get-Reconocimiento]" ) {


    Reconocimiento * a1 = new Reconocimiento("Pepe",60,"reconocimiento");
    REQUIRE( a1->getNombre() == "Pepe" );
    REQUIRE( a1->getCreditos() == 60 );
    REQUIRE( a1->getDescripcion() == "reconocimiento" );
}


TEST_CASE("Comprobando métodos setNombre y getNombre Reconocimiento", "[Nombre-Reconocimiento]" ) {
    Actividad * a1 = new Reconocimiento("Pepe",60,"reconocimiento");
    a1->setNombre("Juan");
    REQUIRE( a1->getNombre() == "Juan" );
}

TEST_CASE("Comprobando métodos setCreditos y getCreditos Reconocimiento", "[Creditos-Reconocimiento]" ) {
    Actividad * a1 = new Reconocimiento("Pepe",60,"reconocimiento");
    a1->setCreditos(54);
    REQUIRE( a1->getCreditos() == 54 );
}


TEST_CASE("Comprobando métodos setDescripcion y getDescripcion Reconocimiento", "[Descripcion-Reconocimiento]" ) {
    Reconocimiento * a1 = new Reconocimiento("Pepe",60,"reconocimiento");
    a1->setDescripcion("prueba");
    REQUIRE( a1->getDescripcion() == "prueba");
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

    Asignatura * a1 = new Asignatura("POO",60,801,Troncal);
    Estudiante * e1 = new Estudiante("peperez",true);



    Matricula * m = new Matricula(a1,e1,C1718,M1,10);
    REQUIRE( m->getActividad()->getNombre() == "POO" );
    REQUIRE( m->getActividad()->getCreditos() == 60 );

    REQUIRE( m->getEstudiante()->getCuasi() == "peperez" );
    REQUIRE( m->getEstudiante()->getFamiliaNumerosa() == true);
    REQUIRE( m->getEstudiante()->getFamiliaNumerosa() == true);
    REQUIRE( m->getCurso() == C1718);
    REQUIRE( m->getOrdenMatricula() == M1);

}


TEST_CASE("Familia no numerosa primera matricula", "[PrimeraMatriculaNoNumerosa]" ) {

        Actividad * act1 = new Asignatura("POO", 6, 2010, Troncal);
		Actividad * act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante * est1 = new Estudiante("peperez",false);
		Matricula * m1 = new Matricula(act1, est1, C1617,M1,20);
		Matricula * m2 = new Matricula(act2, est1, C1718,M1,10);

		REQUIRE(120 == m1->getPrecio());
		REQUIRE(20==m2->getPrecio());

}


TEST_CASE("Familia no numerosa segunda matricula", "[SegundaMatriculaNoNumerosa]" ) {

        Actividad * act1 = new Asignatura("POO", 6, 2010, Troncal);
		Actividad * act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante * est1 = new Estudiante("peperez",false);
		Matricula * m1 = new Matricula(act1, est1, C1617,M2,20);
		Matricula * m2 = new Matricula(act2, est1, C1718,M2,10);

		REQUIRE(240 == m1->getPrecio());
		REQUIRE(40==m2->getPrecio());

}

TEST_CASE("Familia no numerosa tercera matricula", "[TerceraMatriculaNoNumerosa]" ) {

Actividad * act1 = new Asignatura("POO", 6, 2010, Troncal);
		Actividad * act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante * est1 = new Estudiante("peperez",false);
		Matricula * m1 = new Matricula(act1, est1, C1617,M3,20);
		Matricula  * m2 = new Matricula(act2, est1, C1718,M3,10);

		REQUIRE(528 == m1->getPrecio());
		REQUIRE(88==m2->getPrecio());
}


TEST_CASE("Familia no numerosa cuarta matricula", "[CuartaMatriculaNoNumerosa]" ) {
Actividad * act1 = new Asignatura("POO", 6, 2010, Troncal);
		Actividad * act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante * est1 = new Estudiante("peperez",false);
		Matricula * m1 = new Matricula(act1, est1, C1617,M4,20);
		Matricula * m2 = new Matricula(act2, est1, C1718,M4,10);

		REQUIRE(720 == m1->getPrecio());
		REQUIRE(120==m2->getPrecio());
}

TEST_CASE("Familia numerosa", "[Numerosa]" ) {
Actividad * act1 = new Asignatura("POO", 6, 2010, Troncal);
		Actividad * act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Actividad *  act3 = new Asignatura("TP",6, 2010, Obligatoria);
		Actividad  * act4 = new Reconocimiento("Deportes", 4, "Campeonatos universitarios");
		Estudiante  * est1 = new Estudiante("peperez",true);
		Matricula * m1 = new Matricula(act1, est1, C1617,M1,20);
		Matricula * m2 = new Matricula(act2, est1, C1718,M2,10);
		Matricula * m3 = new Matricula(act3, est1, C1617,M3,20);
		Matricula * m4 = new Matricula(act4, est1, C1718,M4,10);

		REQUIRE(60==m1->getPrecio());
		REQUIRE(20==m2->getPrecio());
		REQUIRE(264==m3->getPrecio());
		REQUIRE(120==m4->getPrecio());
}

TEST_CASE("Calificacion vacia", "[CalificacionVacia]" ) {
        Actividad * act1 = new Asignatura("POO", 6, 2010, Troncal);
		Estudiante  * est1 = new Estudiante("peperez",true);
		Matricula * m1 = new Matricula(act1, est1, C1617,M1,20);

		REQUIRE(false==m1->getCalificacionAsignada());
}

