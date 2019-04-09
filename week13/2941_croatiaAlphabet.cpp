#include <iostream>
using namespace std;
int main()
{
    string input;
    char CroatiaAlpha[100];
    cin >> input;

    for(int i = 0; i < input.length(); i++)
    {
        CroatiaAlpha[i] = input.at(i);
    }
    
    int len = input.length();
    int count = 0;
    int ans = 0;
    while(count < len){
        int cheCount = count;
        if (CroatiaAlpha[count] == 'c') {
            if (CroatiaAlpha[count+1] == '=' || CroatiaAlpha[count+1] == '-') {count += 2; ans++;}
        }
        if (CroatiaAlpha[count] == 'd') {
            if (CroatiaAlpha[count+1] == '-') {count += 2; ans++;}
            else if (CroatiaAlpha[count+1] == 'z' && CroatiaAlpha[count+2] == '=') {count += 3; ans++;}
        }
        if (CroatiaAlpha[count] == 'l' && CroatiaAlpha[count+1] == 'j') {count += 2; ans++;}
        if (CroatiaAlpha[count] == 'n' && CroatiaAlpha[count+1] == 'j') {count += 2; ans++;}
        if (CroatiaAlpha[count] == 's' && CroatiaAlpha[count+1] == '=') {count += 2; ans++;}
        if (CroatiaAlpha[count] == 'z' && CroatiaAlpha[count+1] == '=') {count += 2; ans++;}
        if (cheCount == count) {
            count++; ans++;
        }
    }
    cout << ans;
}