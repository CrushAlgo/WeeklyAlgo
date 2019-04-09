#include <iostream>
#include <stack>
using namespace std;
struct node
{
    int i;
    int j;
    int preDir;
};
int main()
{
    int N;
    cin >> N;

    int map[16][16];
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < N; j++)
        {
            cin >> map[i][j];
        }
    }
    node n;
    stack<node> s;
    n.i = 0;
    n.j = 1;
    n.preDir = false;
    s.push(n);

    int ansCnt = 0;

    while(s.size() > 0){
        int stTopI = s.top().i;
        int stTopJ = s.top().j;
        int stTopDir = s.top().preDir;
        s.pop();

        if (stTopI == N-1 && stTopJ == N-1) {
            ansCnt++;
        }
        else {
            int dI[3] = {0,1,1};
            int dJ[3] = {1,0,1};
            
            for(int d = 0; d < 3; d++)
            {
                if (stTopDir == 0 && d == 1 || stTopDir == 1 && d == 0) {
                    continue;
                }
                int thisI = stTopI + dI[d];
                int thisJ = stTopJ + dJ[d];
                if (map[thisI][thisJ] == 0 && (thisI < N && thisJ < N)) {
                    n.i = thisI;
                    n.j = thisJ;
                    n.preDir = d;
                    if (d == 2) {
                        if (map[thisI-1][thisJ] == 0 && map[thisI][thisJ-1] == 0) {
                            s.push(n);
                        }
                    }
                    else {
                        s.push(n);
                    }
                }
            }
        }
    }
    cout << ansCnt;
}