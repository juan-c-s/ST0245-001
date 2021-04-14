#include <iostream>
#include <deque>
#include <string>
using namespace std;
int main()
{
    string brokenKB;
    cin >> brokenKB;
    string subcadena = "";
    deque<string> fixedKB;
    bool corchetAbierto = false;
    char caracter;
    for (int i = 0; i < brokenKB.length(); i++)
    {
        caracter = brokenKB[i];

        if (i == brokenKB.length() - 1 && caracter != '[' && caracter != ']')
        {
            if (corchetAbierto)
            {
                fixedKB.push_front(subcadena);
            }
            else
            {
                fixedKB.push_back(subcadena);
            }
            continue;
        }

        if (caracter == '[' || caracter == ']')
        {
            if (corchetAbierto)
            {
                fixedKB.push_front(subcadena);
                subcadena = "";
            }
            else
            {
                cout << "subcadena: " << subcadena;
                fixedKB.push_back(subcadena);
                subcadena = "";
            }
            if (caracter == '[')
            {
                corchetAbierto = true;
            }
            else if (caracter == ']')
            {
                corchetAbierto = false;
            }
        }
        else
        {
            string character(1, caracter);
            subcadena += character;
        }
    }
    string fixed = "";
    for (int i = 0; i < fixedKB.size(); i++)
    {
        fixed += fixedKB.back();
        fixedKB.pop_front();
    }
    cout << "fixed: " << fixed << endl;
};