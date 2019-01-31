#include <iostream>
#include <vector>

using namespace std;


int main()
{
    int N;
    vector<long long int> inputIndex(1000000);
    vector<int> inputTimes(1000000);

    cin >> N;

    int tail = 0;

    // N번의 input 차례로 받기
    for(int i = 0; i < N; i++)
    {
        long long int input;
        cin >> input;

        bool flag = false;

        // input 하나의 값이 기존에 있는지 판단
        for(int j = 0; j < tail; j++)
        {
            if (input == inputIndex[j]) {
                inputTimes[j]++;
                flag = true;
                break;
            }             
        }
        // flag를 이용하여 새로운 값인지 확인 & 배열에 넣기
        if (flag == false) {
            inputIndex[tail] = input;
            inputTimes[tail]++;
            tail++;
        }
    }
    
    // 최댓값 찾기
    int temp = 0;
    int idx = 0;
    for(int i = 1; i < N; i++)
    {
        if(inputTimes[idx] < inputTimes[i]){
            temp = inputTimes[i];
            idx = i;
        }
        else if (inputTimes[idx] == inputTimes[i]) {
            // inputTimes가 같다면 더 적은 값 찾기
            if (inputIndex[idx] > inputIndex[i]) {
                idx = i;
            }
        }
    }
    cout << inputIndex[idx];;
}
