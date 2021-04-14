
#pragma once
class WordNode

{
public:
    WordNode *next;
    WordNode *prev;
    char data;
    WordNode(char data)
    {
        this->data = data;
    }
};