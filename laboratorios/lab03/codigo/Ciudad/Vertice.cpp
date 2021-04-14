#pragma once
#include <iostream>
#include <string>
#include <vector>
#include <deque>
#include "Arco.cpp"

class Vertice
{
public:
    std::deque<Arco> *calles;
    int ID;
    double x;
    double y;
    std::string nombre;
    ~Vertice(){};
    Vertice(int ID, double x, double y, std::string nombre = "desconocido")
    {
        this->ID = ID;
        this->x = x;
        this->y = y;
        this->nombre = nombre;
    }
};