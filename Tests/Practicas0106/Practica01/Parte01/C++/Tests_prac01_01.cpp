#include <iostream>
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "Circunferencia.h"

using namespace std;


TEST_CASE("Comprobando constructores y método getRadio", "[Constructores]" ) {
    Circunferencia c1;
    REQUIRE( c1.getRadio() == 0 );

    Circunferencia c2 (5.0);
    REQUIRE( c2.getRadio() == 5.0 );

    Circunferencia * pc1 = new Circunferencia();
    REQUIRE( pc1->getRadio() == 0 );

    Circunferencia * pc2 = new Circunferencia(5.0);
    REQUIRE( pc2->getRadio() == 5.0 );
}


TEST_CASE("Comprobando métodos getRadio y setRadio", "[Radio]" ) {
    Circunferencia c1;
    c1.setRadio(10.0);
    REQUIRE(c1.getRadio() == 10.0);

    Circunferencia * pc2 = new Circunferencia(5.0);
    pc2->setRadio(5.3);
    REQUIRE( pc2->getRadio() == 5.3 );
}

TEST_CASE("Comprobando métodos getDiametro y setDiametro", "[Diámetro]" ) {
    Circunferencia c2 (5.0);
    REQUIRE( c2.getDiametro() == 10.0 );
    c2.setDiametro(15.0);
    REQUIRE( c2.getDiametro() == 15.0 );
    REQUIRE( c2.getRadio() == 7.5 );

    Circunferencia * pc2 = new Circunferencia(5.0);
    pc2->setRadio(0.2);
    REQUIRE( pc2->getDiametro() == 0.4 );
}


TEST_CASE("Comprobando métodos getLongitud y setLongitud", "[Longitud]" ) {
    Circunferencia c2 (5.0);
    stringstream ss1;
    ss1 << fixed << setprecision(6) << c2.getLongitud();
    string Longitud = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 31.416;
    string LongitudExpected = ss2.str();
    REQUIRE( LongitudExpected == Longitud);


    c2.setLongitud(3.1416);
    ss1 << fixed << setprecision(6) << c2.getRadio();
    string Radio = ss1.str();
    ss2 << fixed << setprecision(6) << 0.5;
    string RadioExpected = ss2.str();
    REQUIRE( Radio == RadioExpected);
    ss1 << fixed << setprecision(6) << c2.getLongitud();
    Longitud = ss1.str();
    ss2 << fixed << setprecision(6) << 3.1416;
    LongitudExpected = ss2.str();
    REQUIRE( LongitudExpected == Longitud);


    Circunferencia * pc1 = new Circunferencia();
    REQUIRE( pc1->getLongitud() == 0.0 );
    pc1->setLongitud(0.62832);

    ss1 << fixed << setprecision(6) << pc1->getRadio();
    Radio = ss1.str();
    ss2 << fixed << setprecision(6) << 0.1;
    RadioExpected = ss2.str();
    REQUIRE( Radio == RadioExpected);
    ss1 << fixed << setprecision(6) <<  pc1->getLongitud();
    Longitud = ss1.str();
    ss2 << fixed << setprecision(6) << 0.62832;
    LongitudExpected = ss2.str();
    REQUIRE( LongitudExpected == Longitud);

}


TEST_CASE("Comprobando métodos getArea y setArea", "[Area]" ) {
    Circunferencia c2 (5.0);
    stringstream ss1;
    ss1 << fixed << setprecision(6) << c2.getArea();
    string Area = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 78.54;
    string AreaExpected = ss2.str();
    REQUIRE( Area == AreaExpected);


    c2.setArea(3.1416);
    ss1 << fixed << setprecision(6) << c2.getRadio();
    string Radio = ss1.str();
    ss2 << fixed << setprecision(6) << 1.0;
    string RadioExpected = ss2.str();
    REQUIRE( Radio == RadioExpected);
    ss1 << fixed << setprecision(6) << c2.getArea();
    Area = ss1.str();
    ss2 << fixed << setprecision(6) << 3.1416;
    AreaExpected = ss2.str();
    REQUIRE( AreaExpected == Area);


    Circunferencia * pc1 = new Circunferencia();
    REQUIRE( pc1->getArea() == 0.0 );
    pc1->setArea(0.125664);

    ss1 << fixed << setprecision(6) << pc1->getRadio();
    Radio = ss1.str();
    ss2 << fixed << setprecision(6) << 0.2;
    RadioExpected = ss2.str();
    REQUIRE( Radio == RadioExpected);
    ss1 << fixed << setprecision(6) <<  pc1->getArea();
    Area = ss1.str();
    ss2 << fixed << setprecision(6) << 0.125664;
    AreaExpected = ss2.str();
    REQUIRE( Area == AreaExpected);

}
