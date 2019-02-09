#include <iostream>

using namespace std;

int main()
{
    int x,y,w,h;
    
    cin >> x;
    cin >> y;
    cin >> w;
    cin >> h;

    int minimum;
    if (x > y) {
        minimum = y;
    } else{
        minimum = x;
    }
    if (w-x < minimum) {
        minimum = w-x;
    }
    if (h-y < minimum) {
        minimum = h-y;
    }
    cout << minimum;
    return 0;
}