#include <iostream>
#include "WordNode.cpp"
#include <string>
using namespace std;
class DamagedKB
{
public:
    string damagedText;
    string fixedText;
    WordNode *head;
    WordNode *tail;

    DamagedKB(string damagedText)
    {
        this->damagedText = damagedText;
        stringToLL();
        Fix();
    }
    void stringToLL()
    {
        WordNode *temp = this->head;
        for (int i = 0; i < damagedText.length(); i++)
        {
            addLast(damagedText[i]);
        }
    }

    void Fix()
    {
        int i = 0;
        for (WordNode *temp = this->head; temp != NULL && i < this->damagedText.length(); temp = temp->next)
        {
            if (temp->data != ']' && temp->data != '[')
            {
                continue;
            }
            else if (temp->data == '[')
            {
                WordNode *start = temp->next;
                WordNode *end;

                for (WordNode *newTemp = start; newTemp != NULL && i < this->damagedText.length(); newTemp = temp->next)
                {
                    if (newTemp->data == '[')
                    {
                        end = newTemp->prev;
                        //end es igual a el numero antes del nuevo corchete
                        temp->prev->next = newTemp->next;
                        //el proximo del anterior será el próximo del nuevo corchete
                        newTemp->next->prev = temp->prev->next;
                        //el anterior del numero dsps del corchete es el proximo del numero que esta antes del primer corchete
                        end->next = this->head;
                        //el proximo del fin de la subsecuencia será el head.
                        this->head->prev = end;
                        //el anterior del head será el ultimo de la subsecuencia
                        start->prev = NULL;
                        //no hay nada antes del start ya que sería el head
                        this->head = start;
                        //el head cambia al primero de la subsecuencia
                        //<------ YA SE DEBIÓ DE MOVER LA SUBSECUENCIA  -------->
                        //AHORA TOCA SEGUIR CON LA OTRA SUBSECUENCIA
                        start = newTemp->next;
                        end = this->tail;
                        i++;
                        continue;
                    }
                    i++;
                }
            }
            i++;
        }
    }
    void toString()
    {
        cout << "[";
        for (WordNode *temp = this->head; temp != NULL; temp = temp->next)
        {
            cout << temp->data << ", ";
        }
        cout << "]\n";
    }
    // void fixText()
    // {
    //     for (WordNode *temp = this->head; temp != NULL; temp = temp->next)
    //     {
    //         if ()
    //     }
    // }
    void addFirst(int data)
    {
        WordNode *newNode = new WordNode(data);
        if (this->head == NULL)
        {
            this->tail = newNode;
        }
        newNode->next = this->head;
        this->head = newNode;
    }
    void addLast(int data)
    {
        WordNode *newNode = new WordNode(data);
        if (head == NULL)
        {
            this->head = newNode;
            this->tail = newNode;
            return;
        }
        this->tail->next = newNode;
        newNode->prev = this->tail;
        this->tail = newNode;
    }

private:
};