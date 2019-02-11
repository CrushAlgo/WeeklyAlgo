#include <iostream>
using namespace std;

int T;
long long int P[101]  = {1,1,1,2,2,3,4,5,7,9};
int N[100];
int padovan(int Plast, int Nindex);

int main()
{
    cin >> T;
    for(int i = 0; i < T; i++)
    {
        cin >> N[i];
    }    

    int Plast = 10;

    for(int i = 0; i < T; i++)
    {
        if (N[i] >= Plast) {
            padovan(Plast,i);
            Plast = N[i];        
        }
        cout << P[N[i]-1] << "\n";
    }
    return 0;
}

int padovan(int Plast, int Nindex)
{
    for(int i = Plast; i <= N[Nindex]; i++)
    {
        P[i] = P[i-1] + P[i-5];
    }
    return 0;
}