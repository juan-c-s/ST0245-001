#include <iostream>
#include "Node.cpp"

using namespace std;
class FIFO
{
public:
    Node *head;
    Node *tail;

    FIFO()
    {
        this->head = NULL;
        this->tail = NULL;
    }
    void addFirst(int data)
    {
        Node *newNode = new Node(data);
        if (this->head == NULL)
        {
            this->tail = newNode;
        }
        newNode->next = this->head;
        this->head = newNode;
    }
    void addLast(int data)
    {
        Node *newNode = new Node(data);
        if (head == NULL)
        {
            this->head = newNode;
            this->tail = newNode;
            return;
        }
        //Agregando de forma lineal
        this->tail->next = newNode;
        this->tail = newNode;
    }
    void printFIFO()
    {
        cout << "[ ";
        for (Node *temp = head; temp != NULL; temp = temp->next)
        {
            cout << temp->data << ", ";
        }
        cout << "]\n";
    }
};