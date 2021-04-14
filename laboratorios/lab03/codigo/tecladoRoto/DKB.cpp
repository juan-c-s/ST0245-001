#include <iostream>
#include <deque>
#include <cstdlib>

using namespace std;

int main()
{
    deque<char> *s = new deque<char>();
    s.push_front(4);
    s.push_front(2);
    s.push_front(1);
    s.push_front(3);
    s.push_front(5);

    cout << "[";
    for (auto i = s.begin(); i != s.end(); i++)
    {
        cout << s.pop_back() << ", ";
    }
    cout << "]\n";
}