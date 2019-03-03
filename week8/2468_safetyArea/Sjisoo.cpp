#include <iostream>
#include <vector>
#include <stack>
using namespace std;
struct node
{
    int i;
    int j;
};
int N;
vector<vector<int>> map(102,vector<int>(102));
vector<vector<int>> mapTemp(102,vector<int>(102));
int MIN = 100;
int MAX = 1;
int nowWater = 0;
stack<node> s;

void raining(int waterHeight);
int findArea();
void dfs(int i, int j);

int main()
{
    // input
    cin >> N;
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            cin >> map[i][j];
            if (map[i][j] > MAX) {
                MAX = map[i][j];
            }
            if (map[i][j] < MIN) {
                MIN = map[i][j];
            }
        }
    }
    // padding: 1
    for(int i = 0; i <= N+1; i++)
    {
        map[0][i] = 0;
        map[N+1][i] = 0;
    }
    for(int i = 1; i <= N; i++)
    {
        map[i][0] = 0;
        map[i][N+1] = 0;
    }

    // solution    
    nowWater = MIN;
    int MaxArea = 1;
    while(nowWater < MAX){
        raining(nowWater);
        nowWater++;
        mapTemp = map;
        int thisArea = findArea();
        if (thisArea > MaxArea) {
            MaxArea = thisArea;
        }
    }
    cout << MaxArea;
}
void raining(int waterHeight)
{
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            if (map[i][j] == waterHeight) {
                map[i][j] = 0;
            }
        }
    }
}
int findArea()
{
    int Area = 0;
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            if (mapTemp[i][j] == 0) {
                continue;
            } else{
                dfs(i,j);
                Area++;
            }
        }
    }
    return Area;
}
void dfs(int i, int j)
{
    mapTemp[i][j] = 0;

    node n;
    // E S W N
    int dI[4] = {0,1,0,-1};
    int dJ[4] = {1,0,-1,0};
    for(int d = 0; d < 4; d++)
    {
        int thisI = i+dI[d];
        int thisJ = j+dJ[d];
        if (mapTemp[thisI][thisJ] != 0) {
            n.i = thisI;
            n.j = thisJ;
            s.push(n);
        }
    }

    if (s.size() > 0) {
        int nextI = s.top().i;
        int nextJ = s.top().j;
        s.pop();
        return dfs(nextI,nextJ);
    }
    
}