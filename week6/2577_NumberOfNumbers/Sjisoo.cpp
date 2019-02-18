#include <iostream>
#include <math.h>
using namespace std;
int main()
{
    int A,B,C;
    int ABC;
    int numbers[10] = {0,0,0,0,0,0,0,0,0,0};
    cin >> A >> B >> C;

    ABC = A*B*C;

    int len = to_string(ABC).length();
    
    for(int i = len-1; i >= 0; i--)
    {
        int here = (int)ABC/pow(10,i);
        numbers[here]++;
        ABC = ABC - here * pow(10,i);
    }

    for(int i = 0; i < 10; i++)
    {
        cout << numbers[i] << "\n";
    }
}