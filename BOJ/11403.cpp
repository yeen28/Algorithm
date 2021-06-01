#include <iostream>
#include <vector>

int main(){
    int n;
    std::cin>> n;
    std::vector<std::vector<int>> table(n, std::vector<int>(n, 0));

    for (int i = 0; i < n; i++)
        for(int j=0; j<n; j++)
            std::cin >> table[i][j];

    // Floyd-Warshall
    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (table[i][k] && table[k][j])
                    table[i][j] = 1;

    // 결과출력
    for (auto a : table) {
        for (int i = 0; i < n; i++)
            std::cout << a[i] << ' ';
        std::cout << '\n';
    }

    return 0;
}
