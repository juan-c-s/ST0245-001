#include <vector>
#include <iostream>
#include <string>
#include <deque>
#include <cstdlib>

using namespace std;

class UnOrderedSet
{
public:
    vector<deque<pair<string, int> > > contacts;
    UnOrderedSet()
    {
        contacts.resize(16);
    }
    int hashFunction(string s)
    {
        int num = s[0] + s[1] * s[2];
        return num % 16;
    }
    void insert(string name, int phoneNumber)
    {
        int index = hashFunction(name);
        pair<string, int> info(name, phoneNumber);
        this->contacts[index].push_back(info);
    }
    int getPerson(string name)
    {
        int index = hashFunction(name);
        int num;
        for (int i = 0; i < contacts[index].size(); i++)
        {
            pair<string, int> currPerson = contacts[index].at(i);
            if (currPerson.first == name)
            {
                num = currPerson.second;
            }
        }
        return num;
    }
    string toString()
    {
        string str = "{";
        for (int i = 0; i < contacts.size(); i++)
        {
            str += "[";
            for (int it = 0; it < contacts[i].size(); ++it)
            {
                str += "( " + contacts[i].at(it).first + ", " + to_string(contacts[i].at(it).second) + "), ";
            }
            str += "],";
        }
        str = str + "}";
        return str;
    }
};