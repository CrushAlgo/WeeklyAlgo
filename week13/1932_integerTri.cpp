#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
    int N;
    cin >> N;

    int DP[500][500];
    int triangle[500][500];
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j <= i; j++)
        {
            cin >> triangle[i][j];
        }
    }

    DP[0][0] = triangle[0][0];
    for(int i = 1; i < N; i++)
    {
        DP[i][0] = DP[i-1][0] + triangle[i][0];
        DP[i][i] = DP[i-1][i-1] + triangle[i][i];
    }
    

    for(int i = 2; i < N; i++)
    {
        for(int j = 1; j < i; j++)
        {
            DP[i][j] = max(DP[i-1][j-1]+triangle[i][j],DP[i-1][j]+triangle[i][j]);
        }
    }
    sort(DP[N-1],DP[N-1]+N);
    cout << DP[N-1][N-1];
}