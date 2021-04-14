#include <iostream>
#include "WordNode.cpp"
#include <string>
using namespace std;
class DamagedKB2
{
public:
    string damagedText;
    string fixedText;
    WordNode *head;
    WordNode *tail;
    int amountOfBrackets;
    ;

    DamagedKB2(string damagedText)
    {
        this->damagedText = damagedText;
        stringToLL();
        AmountOfBrackets();
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
    void AmountOfBrackets()
    {
        this->amountOfBrackets = 0;
        for (int i = 0; i < this->damagedText.length(); i++)
        {
            if (damagedText[i] == '[' || damagedText[i] == ']')
                this->amountOfBrackets++;
        }
        cout << "Brackets: " << this->amountOfBrackets << endl;
    }
    void Fix()
    {
        int i = 0;
        WordNode *tailOfNoneWrittenWords = this->tail;
        for (WordNode *temp = this->head; temp != NULL && i < this->damagedText.length() - 3; temp = temp->next)
        {
            if (temp->data != ']' && temp->data != '[')
            {
                i++;
                continue;
            }

            else if (temp->data == '[')
            {

                tailOfNoneWrittenWords->next = this->head;
                //El próximo de la cola es igual a la cabeza

                this->head->prev = tailOfNoneWrittenWords;
                //el anterior de la cabeza es la cola
                this->head = temp->next;
                //la nueva cabeza es el próximo del corchete
                cout << "tail: " << this->tail->data << endl;
                this->tail = temp->prev;
                cout << "tail after assigning to teh number before [: " << this->tail->data << endl;

                //la cola es el número antes del corchete
                this->head->prev = NULL;
                //el anterior de la cabeza es NULL

                this->tail->next = NULL;
                cout << "tail: " << this->tail->data << ", tail of none written words: " << tailOfNoneWrittenWords->data << " head: " << this->head->data << endl;

                temp = this->head;
                //el corchete se pone nulo

                i++;
                continue;
            }
            // else if(temp->data==']'){

            // }
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