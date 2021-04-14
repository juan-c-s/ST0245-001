#pragma once
#include <vector>
using namespace std;
class Node
{
public:
    Node(int data)
    {
        this->data = data;
    }
    Node *next;
    Node *prev;
    int data;
};
