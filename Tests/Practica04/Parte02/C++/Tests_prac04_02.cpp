#include <iostream>
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include <iomanip> // setprecision
#include <sstream> // stringstream
#include <string>
#include "Punto.h"
#include "Polilinea.h"

using namespace std;


TEST_CASE("Comprobando constructores y métodos getX y getY", "[Constructores-GetX-GetY]" ) {
    Punto p;
    REQUIRE( p.getX() == 0.0 );
    REQUIRE( p.getY() == 0.0 );

    Punto * p1 = new Punto(5.0,5.0);
    stringstream ss1;
    ss1 << fixed << setprecision(6) << p1->getX();
    string p1X = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 5.0;
    string p1XExpected = ss2.str();
    REQUIRE( p1X == p1XExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << p1->getY();
    string p1Y = ss1.str();
    ss2 << fixed << setprecision(6) << 5.0;
    string p1YExpected = ss2.str();
    REQUIRE( p1Y == p1YExpected);


}


TEST_CASE("Comprobando métodos setX y getX", "[Get-Set-X]" ) {
    Punto * p = new Punto(7.5,7.2);
    p->setX(3.2);
    stringstream ss1;
    ss1 << fixed << setprecision(6) << p->getX();
    string pX = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 3.2;
    string pXExpected = ss2.str();
    REQUIRE( pX == pXExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << p->getY();
    string pY = ss1.str();
    ss2 << fixed << setprecision(6) << 7.2;
    string pYExpected = ss2.str();
    REQUIRE( pY == pYExpected);
}


TEST_CASE("Comprobando métodos setY y getY", "[Get-Set-Y]" ) {
    Punto * p = new Punto(7.5,7.2);
    p->setY(3.5);
    stringstream ss1;
    ss1 << fixed << setprecision(6) << p->getX();
    string pX = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 7.5;
    string pXExpected = ss2.str();
    REQUIRE( pX == pXExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << p->getY();
    string pY = ss1.str();
    ss2 << fixed << setprecision(6) << 3.5;
    string pYExpected = ss2.str();
    REQUIRE( pY == pYExpected);
}

TEST_CASE("Comprobando método getCoordRadial", "[Get-CoordRadial]" ) {

    Punto * p1 = new Punto(7.5,3.2);
    stringstream ss1;
    ss1 << fixed << setprecision(6) << p1->getCoordRadial();
    string p1CoordRadial = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 8.15414;
    string p1CoordRadialExpected = ss2.str();
    REQUIRE( p1CoordRadial == p1CoordRadialExpected);

    Punto * p2 = new Punto(-3.4,0);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << p2->getCoordRadial();
    string p2CoordRadial = ss1.str();
    ss2 << fixed << setprecision(6) << 3.4;
    string p2CoordRadialExpected = ss2.str();
    REQUIRE( p2CoordRadial == p2CoordRadialExpected);


    Punto * p3 = new Punto(-3.4,3.2);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << p3->getCoordRadial();
    string p3CoordRadial = ss1.str();
    ss2 << fixed << setprecision(6) << 4.669047;
    string p3CoordRadialExpected = ss2.str();
    REQUIRE( p3CoordRadial == p3CoordRadialExpected);

    Punto * p4 = new Punto(-5.77,-4.5);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << p4->getCoordRadial();
    string p4CoordRadial = ss1.str();
    ss2 << fixed << setprecision(6) << 7.317301;
    string p4CoordRadialExpected = ss2.str();
    REQUIRE( p4CoordRadial == p4CoordRadialExpected);

    Punto * p5 = new Punto(0,6.3);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << p5->getCoordRadial();
    string p5CoordRadial = ss1.str();
    ss2 << fixed << setprecision(6) << 6.3;
    string p5CoordRadialExpected = ss2.str();
    REQUIRE( p5CoordRadial == p5CoordRadialExpected);

    Punto * p6 = new Punto(0,-9.8);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << p6->getCoordRadial();
    string p6CoordRadial = ss1.str();
    ss2 << fixed << setprecision(6) << 9.8;
    string p6CoordRadialExpected = ss2.str();
    REQUIRE( p6CoordRadial == p6CoordRadialExpected);

    Punto * p7 = new Punto(0,0);
    REQUIRE( p7->getCoordRadial() == 0 );
}


TEST_CASE("Comprobando método getCoordAngular", "[Get-CoordAngular]" ) {
    Punto * p1 = new Punto(7.5,3.2);
    stringstream ss1;
    ss1 << fixed << setprecision(5) << p1->getCoordAngular();
    string p1CoordAngular = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(5) << 0.40328;
    string p1CoordAngularExpected = ss2.str();
    REQUIRE( p1CoordAngular == p1CoordAngularExpected);

    Punto * p2 = new Punto(-3.4,0);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p2->getCoordAngular();
    string p2CoordAngular = ss1.str();
    ss2 << fixed << setprecision(5) << 3.14159;
    string p2CoordAngularExpected = ss2.str();
    REQUIRE( p2CoordAngular == p2CoordAngularExpected);

    Punto * p3 = new Punto(-3.4,3.2);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p3->getCoordAngular();
    string p3CoordAngular = ss1.str();
    ss2 << fixed << setprecision(5) << 2.38649;
    string p3CoordAngularExpected = ss2.str();
    REQUIRE( p3CoordAngular == p3CoordAngularExpected);

    Punto * p4 = new Punto(-5.77,-4.5);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p4->getCoordAngular();
    string p4CoordAngular = ss1.str();
    ss2 << fixed << setprecision(5) << -2.47923;
    string p4CoordAngularExpected = ss2.str();
    REQUIRE( p4CoordAngular == p4CoordAngularExpected);

    Punto * p5 = new Punto(0,6.3);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p5->getCoordAngular();
    string p5CoordAngular = ss1.str();
    ss2 << fixed << setprecision(5) << 1.5708;
    string p5CoordAngularExpected = ss2.str();
    REQUIRE( p5CoordAngular == p5CoordAngularExpected);

    Punto * p6 = new Punto(0,-9.8);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p6->getCoordAngular();
    string p6CoordAngular = ss1.str();
    ss2 << fixed << setprecision(5) << -1.5708;
    string p6CoordAngularExpected = ss2.str();
    REQUIRE( p6CoordAngular == p6CoordAngularExpected);

    Punto * p7 = new Punto(0,0);
    REQUIRE( p7->getCoordAngular() == 0 );

}


TEST_CASE("Comprobando método setCoordRadial", "[Set-CoordRadial]" ) {
    Punto * p1 = new Punto(7.5,3.2);
    p1->setCoordRadial(4.2);
    stringstream ss1;
    ss1 << fixed << setprecision(5) << p1->getCoordRadial();
    string p1Radial = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(5) <<4.2;
    string p1RadialExpected = ss2.str();
    REQUIRE( p1Radial == p1RadialExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p1->getX();
    string p1X = ss1.str();
    ss2 << fixed << setprecision(5) << 3.86307;
    string p1XExpected = ss2.str();
    REQUIRE( p1X == p1XExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p1->getY();
    string p1Y = ss1.str();
    ss2 << fixed << setprecision(5) << 1.64824;
    string p1YExpected = ss2.str();
    REQUIRE( p1Y == p1YExpected);

    Punto * p2 = new Punto(-3.4,-2);
    p2->setCoordRadial(50.9);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p2->getCoordRadial();
    string p2Radial = ss1.str();
    ss2 << fixed << setprecision(5) << 50.9;
    string p2RadialExpected = ss2.str();
    REQUIRE( p2Radial == p2RadialExpected );

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p2->getX();
    string p2X = ss1.str();
    ss2 << fixed << setprecision(5) << -43.87245;
    string p2XExpected = ss2.str();
    REQUIRE( p2X == p2XExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p2->getY();
    string p2Y = ss1.str();
    ss2 << fixed << setprecision(5) << -25.80732;
    string p2YExpected = ss2.str();
    REQUIRE( p2Y == p2YExpected);

}

TEST_CASE("Comprobando método setCoordAngular", "[Set-CoordAngular]" ) {
    Punto * p1 = new Punto(7.5,3.2);
    p1->setCoordAngular(0.78538);
    stringstream ss1;
    ss1 << fixed << setprecision(5) << p1->getCoordAngular();
    string p1Angular = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(5) <<0.78538;
    string p1AngularExpected = ss2.str();
    REQUIRE( p1Angular == p1AngularExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p1->getX();
    string p1X = ss1.str();
    ss2 << fixed << setprecision(5) <<5.76595;
    string p1XExpected = ss2.str();
    REQUIRE( p1X == p1XExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p1->getY();
    string p1Y = ss1.str();
    ss2 << fixed << setprecision(5) << 5.76574;
    string p1YExpected = ss2.str();
    REQUIRE( p1Y == p1YExpected);

    Punto * p2 = new Punto(-3.4,-2);
    p2->setCoordAngular(-0.52358);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p2->getCoordAngular();
    string p2Angular = ss1.str();
    ss2 << fixed << setprecision(5) <<-0.52358 ;
    string p2AngularExpected = ss2.str();
    REQUIRE( p2Angular == p2AngularExpected);


    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p2->getX();
    string p2X = ss1.str();
    ss2 << fixed << setprecision(5) << 3.41618;
    string p2XExpected = ss2.str();
    REQUIRE( p2X == p2XExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(5) << p2->getY();
    string p2Y = ss1.str();
    ss2 << fixed << setprecision(5) << -1.97224;
    string p2YExpected = ss2.str();
    REQUIRE( p2Y == p2YExpected);

}

TEST_CASE("Comprobando método sumar", "[Sumar]" ) {
    Punto * p1 = new Punto(7.5,3.2);
    Punto p2;
    p1->sumarCoordenadas(p2);

    	stringstream ss1;
    ss1 << fixed << setprecision(6) <<p1->getX();
    string p1X = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 7.5;
    string p1XExpected = ss2.str();



    REQUIRE(p1X == p1XExpected );


    ss1 << fixed << setprecision(6) <<p1->getY();
    string p1Y = ss1.str();
    ss2 << fixed << setprecision(6) << 3.2;
    string p1YExpected = ss2.str();
    REQUIRE( p1Y == p1YExpected );

    Punto p3 (2.4,-4.2);
    p1->sumarCoordenadas(p3);

    ss1 << fixed << setprecision(6) <<p1->getX();
    p1X = ss1.str();
    ss2 << fixed << setprecision(6) <<9.9;
    p1XExpected = ss2.str();
    REQUIRE( p1X == p1XExpected );
    ss1 << fixed << setprecision(6) <<p1->getY();
    p1Y = ss1.str();
    ss2 << fixed << setprecision(6) << -1.0;
    p1YExpected = ss2.str();
    REQUIRE( p1Y == p1YExpected );

    Punto p4 (-2.9,2.0);
    p1->sumarCoordenadas(p4);
    ss1 << fixed << setprecision(6) <<p1->getX();
    p1X = ss1.str();
    ss2 << fixed << setprecision(6) <<7.0;
    p1XExpected = ss2.str();
    REQUIRE( p1X == p1XExpected );
    ss1 << fixed << setprecision(6) <<p1->getY();
    p1Y = ss1.str();
    ss2 << fixed << setprecision(6) << 1.0;
    p1YExpected = ss2.str();
    REQUIRE( p1Y == p1YExpected );
}

TEST_CASE("Comprobando método norma", "[Norma]" ) {
    Punto * p1 = new Punto(7.5,3.2);
    stringstream ss1;
    ss1 << fixed << setprecision(4) << p1->norma();
    string p1Norma = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(4) <<8.1541;
    string p1NormaExpected = ss2.str();
    REQUIRE( p1Norma == p1NormaExpected);

    Punto * p2 = new Punto();
    REQUIRE( p2->norma() == 0);

    Punto * p3 = new Punto(-1.0,0);
    REQUIRE( p3->norma() == 1);
}

TEST_CASE("Constructor Polilinea", "[Constructor-Polilinea]" ) {
   Polilinea *pl = new Polilinea("polilinea");
   REQUIRE("polilinea"==pl->getNombre());
   REQUIRE(0==pl->numeroPuntos());

    Polilinea pl2 ("polilinea2");
    REQUIRE("polilinea2"==pl2.getNombre());
    REQUIRE(0== pl2.numeroPuntos());
}


/*
// Este test comprueba dos cosas.
// - Que un punto no está añadido en la polilínea vacía
// - Que al añadir un punto a una polilínea, este pasa a contenterlo.
// Aunque conceptualmente este test es correcto, debido a cuestiones
// de cálculo numérico en C++, puede que aun habiendo programado
// correctamente las funciones de anyadirPunto y contienePunto, este
// test no pase.
TEST_CASE("testContienePunto", "[ContienePunto]" )  {

		Polilinea * pl = new Polilinea("polilinea");
		Punto * p = new Punto(1.0,1.0);
		REQUIRE(false==pl->contienePunto(p));

		pl->anyadirPunto(p);
		REQUIRE(true==pl->contienePunto(p));


		for(int i=1;i<15;i++) {
			p = new Punto(i,i);
			pl->anyadirPunto(p);
			REQUIRE(true==pl->contienePunto(p));
		}

	}

// Este test comprueba tres cosas.
// - Que no podemos añadir dos veces el mismo punto a una polilínea.
// - Que al añadir un punto a una polilínea, este pasa a contenterlo.
// - Que cuando la polilínea está llena no podemos añadir más puntos.
// Aunque conceptualmente este test es correcto, debido a cuestiones
// de cálculo numérico en C++, puede que aun habiendo programado
// correctamente las funciones de anyadirPunto y contienePunto, este
// test no pase.
TEST_CASE("testAnyadirPunto", "[AnyadirPunto]" )  {

		Polilinea * pl = new Polilinea("polilinea");
		Punto * p = new Punto(0.0,0.0);
		pl->anyadirPunto(p);
		REQUIRE(false==pl->anyadirPunto(p));

		for(int i=1;i<15;i++) {
			p = new Punto(i,i);
			pl->anyadirPunto(p);
			REQUIRE(true==pl->contienePunto(p));
		}

		p = new Punto(15.0,15.0);
		REQUIRE(false==pl->anyadirPunto(p));
		REQUIRE(false==pl->contienePunto(p));

	}

// Este test comprueba dos cosas.
// - Que al eliminar un punto de una polilínea, la polilínea deja de
//   contenerlo.
// - Que podemos eliminar puntos en distintas posiciones y el comportamiento
//   es el esperado
// Aunque conceptualmente este test es correcto, debido a cuestiones
// de cálculo numérico en C++, puede que aun habiendo programado
// correctamente las funciones de anyadirPunto, eliminarPunto, y 
// contienePunto, este test no pase.
TEST_CASE("testEliminarPunto", "[EliminarPunto]" )  {

		Polilinea * pl = new Polilinea("polilinea");
		Punto * p = new Punto(0.0,0.0);
		pl->anyadirPunto(p);
		REQUIRE(true==pl->eliminarPunto(p));
		REQUIRE(false==pl->contienePunto(p));


		for(int i=0;i<15;i++) {
			p = new Punto(i,i);
			pl->anyadirPunto(p);
		}

		p = new Punto(15.0,15.0);
		REQUIRE(false==pl->eliminarPunto(p));

		p = new Punto(5.0,5.0);
		REQUIRE(true==pl->eliminarPunto(p));
		REQUIRE(false==pl->contienePunto(p));

		p = new Punto(14,14);
		REQUIRE(true==pl->eliminarPunto(p));
		REQUIRE(false==pl->contienePunto(p));

	}
*/
	TEST_CASE("testEstanAlineados", "[PuntosAlineados]" )  {

        Polilinea * pl = new Polilinea("polilinea");
        REQUIRE(true==pl->estanAlineados());

        Punto *p;
        p = new Punto(0,0);
        pl->anyadirPunto(p);
        REQUIRE(true==pl->estanAlineados());

        p = new Punto(1,1);
        p->setCoordAngular(0);
        pl->anyadirPunto(p);
        REQUIRE(true==pl->estanAlineados());

        for(int i=2;i<13;i++) {
            p = new Punto(i,i);
            p->setCoordRadial(i*i);
            p->setCoordAngular(0);
            pl->anyadirPunto(p);
            REQUIRE(true==pl->estanAlineados());
        }

        p = new Punto(-1,5);
        pl->anyadirPunto(p);
        REQUIRE(false==pl->estanAlineados());

    }


TEST_CASE("testNumeroPuntos", "[NumeroPuntos]" )  {

		Polilinea * pl = new Polilinea("polilinea");
		REQUIRE(0==pl->numeroPuntos());
		Punto * p;

		for(int i=0;i<15;i++) {
			p = new Punto(i,i);
			pl->anyadirPunto(p);
			REQUIRE(i+1==pl->numeroPuntos());
		}

		p = new Punto(15.0,15.0);
		pl->anyadirPunto(p);
		REQUIRE(15==pl->numeroPuntos());
/*
// Se elimina esta parte del test por problemas de cálculo
// numérico en C++.
		for(int i=14;i>=0;i--) {
			p = new Punto(i,i);
			pl->eliminarPunto(p);
			REQUIRE(i==pl->numeroPuntos());
		}
*/
	}


TEST_CASE("testPuntoMasAlejado", "[PuntoMasAlejado]" )  {

		Polilinea *pl = new Polilinea("polilinea");

		REQUIRE(NULL==pl->puntoMasAlejado());


		Punto *p;
		for(int i=0;i<15;i++) {
			p = new Punto(i,i);
			pl->anyadirPunto(p);
		}

			stringstream ss1;
    ss1 << fixed << setprecision(6) <<pl->puntoMasAlejado()->getX();
    string p1X = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 14.0;
    string p1XExpected = ss2.str();

		REQUIRE(p1XExpected== p1X);

		ss1.str(string());
		ss1 << fixed << setprecision(6) <<pl->puntoMasAlejado()->getY();
		string p1Y = ss1.str();

		REQUIRE(p1XExpected==p1Y);

		Polilinea *pl2 = new Polilinea("polilinea");
		for(int i=30;i>=16;i--) {
			p = new Punto(i,i);
			pl2->anyadirPunto(p);
		}

        ss1.str(string());
        ss1 << fixed << setprecision(6) <<pl2->puntoMasAlejado()->getX();
        string p12X = ss1.str();
        ss2.str(string());
        ss2 << fixed << setprecision(6) << 30.0;
        string p12XExpected = ss2.str();
        REQUIRE(p12XExpected==p12X);

		ss1.str(string());
		ss1 << fixed << setprecision(6) <<pl2->puntoMasAlejado()->getY();
		string p12Y = ss1.str();
		REQUIRE( p12XExpected==p12Y);



	}


TEST_CASE("testPuntoMasCercano", "[PuntoMasCercano]" )  {
		Polilinea *pl = new Polilinea("polilinea");


		REQUIRE(NULL==pl->puntoMasCercano());

		Punto *p;
		for(int i=0;i<15;i++) {
			p = new Punto(i,i);
			pl->anyadirPunto(p);
		}
		REQUIRE(0==pl->puntoMasCercano()->getX());
		REQUIRE(0==pl->puntoMasCercano()->getY());

		Polilinea *pl2 = new Polilinea("polilinea");
		for(int i=30;i>=16;i--) {
			p = new Punto(i,i);
			pl2->anyadirPunto(p);
		}

		stringstream ss1;
    ss1 << fixed << setprecision(6) <<pl2->puntoMasCercano()->getX();
    string p1X = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 16.0;
    string p1XExpected = ss2.str();

		REQUIRE(p1XExpected==p1X);


		ss1.str(string());
		ss1 << fixed << setprecision(6) <<pl2->puntoMasCercano()->getY();
		string p1Y = ss1.str();

		REQUIRE(p1XExpected==p1Y);



	}

