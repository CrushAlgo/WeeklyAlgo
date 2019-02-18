#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> input(9);
int sum_all = 0;
int find_nanjang();
int main()
{
    for(int i = 0; i < 9; i++)
    {
        cin >> input[i];
        sum_all += input[i];
    }
    int func = find_nanjang();
    sort(input.begin(),input.end());

    for(int i = 2; i < 9; i++)
    {
        cout << input[i] << "\n";
    }
}
int find_nanjang()
{
    for(int i = 0; i < 8; i++)
    {
        sum_all -= input[i];
        for(int j = i+1; j < 9; j++)
        {
            sum_all -= input[j];
            if (sum_all == 100) {
                input[i] = -1;
                input[j] = -1;
            }
            sum_all += input[j];
        }
        sum_all += input[i];
    }
    return 0;
}