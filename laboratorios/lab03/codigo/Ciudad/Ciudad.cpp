
#pragma once
#include "Vertice.cpp"
#include <iostream>
#include <deque>

class Ciudad
{
public:
    std::deque<Vertice *> *lugares;
    Ciudad() {}
    ~Ciudad(){};
    void toString()
    {

        for (int i = 0; i < this->lugares->size(); i++)
        {
            Vertice *temp = this->lugares->back();
            this->lugares->pop_back();
            std::cout << "ID " << i << ": " << temp->ID;
        }
        std::cout << std::endl;
    }
};