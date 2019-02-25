#include <iostream>
#include <string>
#include <stack>
using namespace std;
int main()
{
    int N;
    cin >> N;
    string input[N];
    bool output[N];
    stack<char> s;

    for(int i = 0; i < N; i++)
    {
        cin >> input[i];
    }

    for(int i = 0; i < N; i++)
    {
        string thisInput = input[i];
        int thisLen = thisInput.length();
        if (thisLen % 2 == 0) {
            for(int j = 0; j < thisLen; j++)
            {
                int thisChar = input[i].at(j);
                if (thisChar == ')') {
                    if (s.size() > 0) {
                        if (s.top() == '(') {
                        s.pop();
                        }else{
                            s.push(thisChar);
                            break;
                        }
                    }else{
                        s.push(thisChar);
                        break;
                    }
                }else{
                    s.push(thisChar);
                }
            }
            if (s.size() == 0) {
                output[i] = true;
            }else{
                while(s.size() > 0){
                    s.pop();
                }
            }
        }
        switch (output[i])
        {
            case false:
                cout << "NO\n";
                break;
        
            case true:
                cout << "YES\n";
                break;
        }
    }
}