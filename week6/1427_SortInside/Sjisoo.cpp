#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
using namespace std;
int main()
{
    string N;
    cin >> N;

    int len = N.length();

    int input = stoi(N);

    vector<int> arr(len);
    for(int i = len-1; i >= 0; i--)
    {
        int here = (int)input/pow(10,i);
        arr[i] = here;
        input = input - here * pow(10,i);
    }
    sort(arr.begin(),arr.end(),greater<int>());
    for(int i = 0; i < len; i++)
    {
        cout << arr[i];
    }
}