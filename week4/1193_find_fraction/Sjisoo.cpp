#include <iostream>
using namespace std;
int main()
{
    int input;
    cin >> input;

    int arrayIndex;

    for(int i = 1; i < 4500; i++)
    {
        int hap = i*(i+1)/2;
        if (input <= hap) {
            arrayIndex = i;
            break;
        }
    }
    int left,right;
    input = input - ((arrayIndex-1)*arrayIndex)/2;
    if (arrayIndex % 2 == 0) {
        left = 0;
        right = arrayIndex+1;
        while(input > 0){
            left++;
            right--;
            input--;
        }        
    } else{
        left = arrayIndex+1;
        right = 0;
        while(input > 0){
            left--;
            right++;
            input--;
        }
    }
    cout << left << "/" << right;
    return 0;
}