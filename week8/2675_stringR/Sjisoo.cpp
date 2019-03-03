#include <iostream>
using namespace std;
int main()
{
    int testCase;
    int inputTimes[1000];
    string inputString[1000];

    cin >> testCase;

    for(int i = 0; i < testCase; i++)
    {
        cin >> inputTimes[i] >> inputString[i];
    }

    for(int i = 0; i < testCase; i++)
    {
        for(int j = 0; j < inputString[i].size(); j++)
        {
            for(int k = 0; k < inputTimes[i]; k++)
            {
                cout << inputString[i].at(j);
            }
        }
        cout << "\n";
    }
    return 0;
}