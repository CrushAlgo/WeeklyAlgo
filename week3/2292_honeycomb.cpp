#include <iostream>
using namespace std;
int main()
{
    int N;
    cin >> N;
    long long int sum = 1;
    if (N == 1) {
        cout << 1;
        return 0;
    }    
    for(int i = 1; i < N; i++)
    {
        sum = sum + 6*i;
        if (sum >= N) {
            cout << i+1;
            return 0;
        }
    }
}