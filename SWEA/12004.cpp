#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

  cin>>T;
	
	vector<int> arr;
    for (test_case = 1; test_case <= T; ++test_case)
    {

        /////////////////////////////////////////////////////////////////////////////////////////////
        cout << "#" << test_case << " ";

        arr.clear();
        long in_num;
        cin >> in_num;

        // 약수 얻기
        for (int i = 1; i <= in_num; i++)
        {
            if (in_num % i == 0)
            {
                arr.push_back(i);
            }
        }

        if (arr.size() % 2 != 0)
        { //약수의 개수 : 홀수
            if (arr[arr.size() / 2] < 10)
            {
                cout << "Yes";
            }
            else
            {
                cout << "No";
            }
        }
        else
        { //약수의 개수 : 짝수
            if (arr[arr.size() / 2 - 1] < 10 && arr[arr.size() / 2] < 10)
            {
                cout << "Yes";
            }
            else
            {
                cout << "No";
            }
        }
        cout << "\n";
		/////////////////////////////////////////////////////////////////////////////////////////////


	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
