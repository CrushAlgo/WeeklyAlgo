#include <iostream>
#include <queue>
#include <stack>
#include <vector>

using namespace std;

int N,M,V;
bool node[10001][10001];

queue<int> q;
queue<int> ans;

stack<int> s;
queue<int> ansS;

bool isVisited[1001];
bool isVisitedS[1001];
void BFS();
void DFS();

int main()
{
    cin >> N;
    cin >> M;
    cin >> V;

    for(int i = 1; i <= M; i++)
    {
        int a,b;
        cin >> a >> b;
        node[a][b] = true;
        node[b][a] = true;
    }
    
    q.push(V);
    ans.push(q.front());
    isVisited[V] = true;

    s.push(V);
    ansS.push(s.top());
    isVisitedS[V] = true;

    DFS();
    BFS();
    
    // DFS 출력
    while(ansS.size() > 0)
    {
        cout << ansS.front() << " ";
        ansS.pop();
    }
    cout << "\n";
    // BFS 출력
    while(ans.size() > 0)
    {
        cout << ans.front() << " ";
        ans.pop();
    }
    
}

void BFS()
{
    while(q.size() > 0)
    {
        int qFront = q.front();

        for(int i = 1; i <= M; i++)
        {
            if (node[qFront][i] == true && isVisited[i] == false) {
                q.push(i);
                ans.push(i);
                isVisited[i] = true;
            }
        }
        q.pop();
    }
}

void DFS()
{
    while(s.size() > 0)
    {
        int s_Top = s.top();
        
        for(int i = 1; i <= M; i++)
        {
            if (node[s_Top][i] == true && isVisitedS[i] == false) {
                s.push(i);
                ansS.push(i);
                isVisitedS[i] = true;
                return DFS();
            }
        }
        s.pop();
    }
}