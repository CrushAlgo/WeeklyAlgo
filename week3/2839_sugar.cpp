#include <iostream>
#include <list>

using namespace std;

int main()
{
    int N;
    cin >> N;
    if (N > 5000 || N < 3) {
        cout << -1;
        return 0;
    }   
    
    list<int> s;
    bool visitCheck5 = false;
    for(int i =0; i<1667; i++)
    {   
        if (N >= 5 && visitCheck5 == false) {
            N = N-5;
            s.push_back(5);
        }
        else if (N >= 3) {
            N = N-3;
            s.push_back(3);
        }
        else if (N == 0) {
            cout << s.size();
            return 0;
        }
        else {
            int stop = s.back();
            if (stop == 5) {
                visitCheck5 = true;
            }
            if (s.front() == 3) {
                cout << -1;
                return 0;
            }
            while(s.back() == 3){
                N = N+s.back();
                s.pop_back();
                if (s.back() == 5) {
                    visitCheck5 = true;
                }
            }
            N = N+s.back();
            s.pop_back();
        }        
    }
}