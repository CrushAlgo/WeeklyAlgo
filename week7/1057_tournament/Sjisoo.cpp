#include <iostream>
using namespace std;
int main()
{
    int N;
    int Kim,Lim;
    cin >> N >> Kim >> Lim;

    for(int i = 0; i < N; i++)
    {
        Kim = (Kim+1)/2;
        Lim = (Lim+1)/2;
        if (Kim == Lim) {
            cout << i+1;
            break;
        }
    }
}