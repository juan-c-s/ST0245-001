#include <iostream>
#include "Node.cpp"

using namespace std;
class DLinkedList
{
private:
    Node *head;
    Node *tail;

public:
    DLinkedList(Node *head, Node *tail)
    {
        this->head = head;
        this->tail = tail;
    }
    DLinkedList()
    {
        this->head = NULL;
        this->tail = NULL;
    }
    void addFirst(int data)
    {
        Node *newNode = new Node(data);
        if (tail == NULL)
            this->tail = newNode;
        newNode->prev = NULL;
        newNode->next = this->head;
        if (head != NULL)
            this->head->prev = newNode;
        this->head = newNode;
    }
    void addLast(int data)
    {
        Node *newNode = new Node(data);
        if (tail == NULL)
        {
            this->head = newNode;
            this->tail = newNode;
        }
        this->tail->next = newNode;
        newNode->prev = this->tail;
        this->tail = newNode;
    }
    void printDll()
    {
        cout << "[";
        for (Node *temp = this->head; temp != NULL; temp = temp->next)
        {
            cout << temp->data << ", ";
        }
        cout << "]\n";
    }
};