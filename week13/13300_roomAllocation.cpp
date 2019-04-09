#include <iostream>
using namespace std;
int main()
{
    int N,K;
    cin >> N >> K;

    int rooms[6][2];
    int stuInfo[1000][2];
    for(int i = 0; i < N; i++)
    {
        cin >> stuInfo[i][0] >> stuInfo[i][1];
        rooms[stuInfo[i][1]-1][stuInfo[i][0]]++;
    }

    int ansRoomNum = 0;
    for(int i = 0; i < 6; i++)
    {
        for(int j = 0; j < 2; j++)
        {
            int thisVal = rooms[i][j] / K;
            int thisRes = rooms[i][j] % K;
            ansRoomNum += thisVal;
            if (thisRes != 0) {
                ansRoomNum++;
            }
        }
    }
    cout << ansRoomNum;
}