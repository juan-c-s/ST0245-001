#include <iostream>
#include "DLinkedList.cpp"
#include "DamagedKB.cpp"
#include "DamagedKB2.cpp"
#include <string>

using namespace std;

int main()

{

    string text = "aasd[fgh[jkl[";
    // DamagedKB *dKB = new DamagedKB(text);

    // // dKB->Fix();
    // dKB->toString();

    DamagedKB2 *dKB2 = new DamagedKB2(text);

    // dKB->Fix();
    dKB2->toString();
}