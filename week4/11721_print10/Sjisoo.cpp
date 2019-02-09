#include <iostream>
#include <string.h>

using namespace std;

int main()
{
    char input[100];
    string input_string;
    
    cin >> input_string;

    strcpy(input,input_string.c_str());
    int len = input_string.size();

    for(int i = 0; i < len; i++)
    {
        cout << input[i];
        if ((i+1)%10 == 0) {
            cout << "\n";
        }
    }
}