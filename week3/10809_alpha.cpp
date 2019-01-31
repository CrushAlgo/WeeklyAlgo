#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main()
{
	string str;
	int alpha[26];
	std::fill_n(alpha, 26, -1);
	cin >> str;

	vector<char> vec(str.begin(), str.end());

	for (int i = 0; i < str.length(); i++)
	{
		if (alpha[vec[i] - 97] == -1)
		{
			alpha[vec[i] - 97] = i;
		}
	}
	for (int j = 0; j < 26; j++)
	{
		cout << alpha[j] << " ";
	}
}