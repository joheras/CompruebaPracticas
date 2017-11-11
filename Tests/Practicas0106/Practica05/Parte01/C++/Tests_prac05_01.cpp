#include <iostream>
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "Circunferencia.h"
#include "Punto.h"
#include "Circunferencia2D.h"

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
    REQUIRE( c2.getLongitud() == 31.416 );
    c2.setLongitud(3.1416);
    REQUIRE(c2.getRadio() == 0.5  );
    REQUIRE( c2.getLongitud() == 3.1416);


    Circunferencia * pc1 = new Circunferencia();
    REQUIRE( pc1->getLongitud() == 0.0 );
    pc1->setLongitud(0.62832);
    REQUIRE( pc1->getRadio() == 0.1 );
    REQUIRE( pc1->getLongitud() == 0.62832 );
}


TEST_CASE("Comprobando métodos getArea y setArea", "[Area]" ) {
    Circunferencia c2 (5.0);

    stringstream ss1;
    ss1 << fixed << setprecision(6) << c2.getArea();
    string a = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 78.54;
    string aExpected = ss2.str();
    REQUIRE( a == aExpected);
    c2.setArea(3.1416);
    REQUIRE(c2.getRadio() == 1.0  );
    REQUIRE( c2.getArea() == 3.1416);


    Circunferencia * pc1 = new Circunferencia();
    REQUIRE( pc1->getArea() == 0.0 );
    pc1->setArea(0.125664);
    REQUIRE( pc1->getRadio() == 0.2 );

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << pc1->getArea();
    a= ss1.str();
    ss2 << fixed << setprecision(6) << 0.125664;
    aExpected = ss2.str();
    REQUIRE( a == aExpected);
}



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


TEST_CASE("Comprobando constructores y método getRadio Circunferencia2D", "[Constructores]" ) {
    Circunferencia2D c1;
    REQUIRE( c1.getRadio() == 0.0 );


    stringstream ss1;
    ss1 << fixed << setprecision(6) << c1.getCentro()->getX();
    string pX = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 0.0;
    string pXExpected = ss2.str();
    REQUIRE( pX == pXExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c1.getCentro()->getY();
    string pY = ss1.str();
    ss2 << fixed << setprecision(6) << 0.0;
    string pYExpected = ss2.str();
    REQUIRE( pY == pYExpected);


    Punto * p = new Punto (3.2,3.2);
    Circunferencia2D c2 (5.0,p);
    REQUIRE( c2.getRadio() == 5.0 );
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c2.getCentro()->getX();
    pX = ss1.str();
    ss2;
    ss2 << fixed << setprecision(6) << 3.2;
    pXExpected = ss2.str();
    REQUIRE( pX == pXExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c2.getCentro()->getY();
    pY = ss1.str();
    ss2 << fixed << setprecision(6) << 3.2;
    pYExpected = ss2.str();
    REQUIRE( pY == pYExpected);



}


TEST_CASE("Comprobando métodos getRadio y setRadio Circunferencia2D", "[Radio]" ) {
    Circunferencia2D c1;
    c1.setRadio(10.0);
    REQUIRE(c1.getRadio() == 10.0);

    Punto * p = new Punto (3.2,3.2);
    Circunferencia2D * pc2 = new Circunferencia2D(5.0,p);
    pc2->setRadio(5.3);
    REQUIRE( pc2->getRadio() == 5.3 );
}

TEST_CASE("Comprobando métodos getDiametro y setDiametro Circunferencia2D", "[Diámetro]" ) {
    Punto * p = new Punto (3.2,3.2);
    Circunferencia2D c2 (5.0,p);

    REQUIRE( c2.getDiametro() == 10.0 );
    c2.setDiametro(15.0);
    REQUIRE( c2.getDiametro() == 15.0 );
    REQUIRE( c2.getRadio() == 7.5 );

}


TEST_CASE("Comprobando métodos getLongitud y setLongitud Circunferencia2D", "[Longitud]" ) {
    Punto * p = new Punto (3.2,3.2);
    Circunferencia2D c2 (5.0,p);
    REQUIRE( c2.getLongitud() == 31.416 );
    c2.setLongitud(3.1416);
    REQUIRE(c2.getRadio() == 0.5  );
    REQUIRE( c2.getLongitud() == 3.1416);



}


TEST_CASE("Comprobando métodos getArea y setArea Circunferencia2D", "[Area]" ) {
    Punto * p = new Punto (3.2,3.2);
    Circunferencia2D c2 (5.0,p);

    stringstream ss1;
    ss1 << fixed << setprecision(6) << c2.getArea();
    string aa = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 78.54;
    string aaExpected = ss2.str();
    REQUIRE( aa == aaExpected);
    //REQUIRE( c2.getArea() == 78.54 );
    c2.setArea(3.1416);
    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c2.getRadio();
    string r = ss1.str();
    ss2 << fixed << setprecision(6) << 1.0;
    string rExpected = ss2.str();
    REQUIRE( r == rExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c2.getArea();
    string a = ss1.str();
    ss2 << fixed << setprecision(6) << 3.1416;
    string aExpected = ss2.str();
    REQUIRE( a == aExpected);

    //REQUIRE(c2.getRadio() == 1.0  );
    //REQUIRE( c2.getArea() == 3.1416);

}


TEST_CASE("Comprobando métodos getCentro y setCentro Circunferencia2D", "[Centro]" ) {
    Punto * p = new Punto (3.2,3.2);
    Circunferencia2D c2 (5.0,p);
    stringstream ss1;
    ss1 << fixed << setprecision(6) << c2.getCentro()->getX();
    string pX = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 3.2;
    string pXExpected = ss2.str();
    REQUIRE( pX == pXExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c2.getCentro()->getY();
    string pY = ss1.str();
    ss2 << fixed << setprecision(6) << 3.2;
    string pYExpected = ss2.str();
    REQUIRE( pY == pYExpected);


    Punto * p1 = new Punto  (4.5,5.6);
    c2.setCentro(p1);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c2.getCentro()->getX();
    pX = ss1.str();
    ss2 << fixed << setprecision(6) << 4.5;
    pXExpected = ss2.str();
    REQUIRE( pX == pXExpected);


    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c2.getCentro()->getY();
    pY = ss1.str();
    ss2 << fixed << setprecision(6) << 5.6;
    pYExpected = ss2.str();
    REQUIRE( pY == pYExpected);

}

TEST_CASE("Comprobando método sumarCoordenadas Circunferencia2D", "[sumarCoordenadas]" ) {
    Punto * p = new Punto (3.2,3.2);
    Circunferencia2D c2 (5.0,p);
    Punto * p1 = new Punto (4.5,5.6);
    c2.sumarCoordenadas(p1);

    stringstream ss1;
    ss1 << fixed << setprecision(6) << c2.getCentro()->getX();
    string pX = ss1.str();
    stringstream ss2;
    ss2 << fixed << setprecision(6) << 7.7;
    string pXExpected = ss2.str();
    REQUIRE( pX == pXExpected);

    ss1.str(string());
    ss2.str(string());
    ss1 << fixed << setprecision(6) << c2.getCentro()->getY();
    string pY = ss1.str();
    ss2 << fixed << setprecision(6) << 8.8;
    string pYExpected = ss2.str();
    REQUIRE( pY == pYExpected);


}
