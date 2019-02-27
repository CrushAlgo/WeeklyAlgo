#include <iostream>
using namespace std;
int main()
{
    int N;
    cin >> N;

    for(int i = 1; i < 1000000; i++)
    {        
        int sum = i;
        int temp = i;
        while(temp != 0){
            sum += temp%10;
            temp /= 10;
        }

        if (sum == N) {
            cout << i;
            return 0;
        }
    }
    cout << 0;
    return 0;
}