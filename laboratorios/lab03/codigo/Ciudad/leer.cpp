#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib>
#include <sstream>
#include "Ciudad.cpp"

// #include "Vertice.cpp"

// class Leer
// {
// public:
// }

using namespace std;
int main()
{
    stringstream ss;
    //variables arco
    int ID1, ID2, distancia;
    string nombreA;

    //variables vertice
    int IDV;
    double x, y;
    string nombreV;

    ifstream MyReadFile("testData.txt");

    bool isVertice = false;
    bool isArco = false;
    // while (getline(MyReadFile, s))
    // {
    //     if (s == "Vertices. Formato: ID coordenadaY coordenadaX nombre")
    //     {
    //         isVertice = true;
    //         isArco = true;
    //         continue;
    //     }

    //     if (s == "Arcos. Formato: ID ID distancia nombre ")
    //     {
    //         isArco = true;
    //         isVertice = false;
    //         continue;
    //     }

    //     stringstream ss(s);
    //     string newS;
    //     // while (getline(ss, newS, ' '))
    //     // {

    //     if (isArco)
    //     {
    //         cin >> ID1 >> ID2 >> distancia >> nombreA;
    //         cout << "<------ Arco -------->" << endl;
    //         cout << "ID1: " << ID1 << ", ID2" << ID2 << ", distancia: " << distancia << ", nombreA" << nombreA << endl;
    //     }
    //     else if (isVertice)
    //     {
    //         s >> IDV >> x >> y, nombreV;
    //         cout << "<------ vertice -------->" << endl;
    //         cout << "ID: " << IDV << ", x" << x << ", y: " << y << ", nombreV" << nombreA << endl;
    //     }
    // }
    // cout << endl;
    // }
    //
    //
    //
    //
    int var;

    string s;
    Ciudad *ciudad = new Ciudad();
    while (getline(MyReadFile, s))
    {
        if (s == "Vertices. Formato: ID coordenadaY coordenadaX nombre")
        {
            isVertice = true;
            isArco = false;
            continue;
        }

        if (s == "Arcos. Formato: ID ID distancia nombre ")
        {
            isArco = true;
            isVertice = false;
            continue;
        }
        stringstream ss(s);

        if (isArco)
        {

            ss >> ID1 >> ID2 >> distancia;
            getline(ss, nombreA);
            cout << "<------ Arco -------->" << endl;
            cout << "ID1: " << ID1 << ", ID2: " << ID2 << ", distancia: " << distancia << ", nombreA: " << nombreA << endl;
        }
        else if (isVertice)
        {
            ss >> IDV >> x >> y;
            getline(ss, nombreV);
            Vertice *newVertice = new Vertice(IDV, x, y, nombreV);
            ciudad->lugares->push_back(newVertice);

            // cout << "<------ vertice -------->" << endl;
            // cout << "ID: " << IDV << ", x: " << x << ", y: " << y << ", nombreV: " << nombreA << endl;
        }
    }
    ciudad->toString();
    return 0;
};