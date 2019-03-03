#include <iostream>
using namespace std;
int main()
{
    int Month,Day;
    cin >> Month >> Day;
    string week[7] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    int days = Day;
    for(int i = 1; i < Month; i++)
    {
        if (i == 2) {
            days += 28;
        } else if (i==4 || i==6 || i==9 || i==11) {
            days += 30;
        } else{
            days += 31;
        }
    }
    int res = days % 7;
    cout << week[res] << "\n";
}