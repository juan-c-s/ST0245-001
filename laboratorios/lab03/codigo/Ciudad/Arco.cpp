
#pragma once
#include "Vertice.cpp"
#include <iostream>
#include <string>

class Arco
{
public:
    std::pair<Vertice, Vertice> *vertices;
    int distancia;
    std::string nombreCalle;
    Arco(Vertice primero, Vertice segundo, int distancia, std::string nombreCalle = "desconocido")
    {
        vertices->first = primero;
        vertices->second = segundo;
        this->distancia = distancia;
        this->nombreCalle = nombreCalle;
    }

private:
};