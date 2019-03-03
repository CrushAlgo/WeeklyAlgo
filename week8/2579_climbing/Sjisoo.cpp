#include <iostream>
#include <algorithm>
using namespace std;
int N;
int stairs[301],dp[301];

int findMaxStairs(int now);

int main()
{
    cin >> N;
    for(int i = 1; i <= N; i++)
    {
        cin >> stairs[i];
    }
    
    dp[1] = stairs[1];
    dp[2] = stairs[2] + stairs[1];

    for(int i = 3; i <= N; i++)
    {        
        int prev = stairs[i] + stairs[i-1] + dp[i-3];
        int pprev = stairs[i] + dp[i-2];
        dp[i] = max(prev,pprev);
    }
    cout << dp[N];
}