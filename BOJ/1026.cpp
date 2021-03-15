#include <iostream>
#include <algorithm>
#include <vector>

int main(){
   int N;
   std::cin>> N;

   std::vector<int> A;
   std::vector<int> B;

   for(int i=0; i<N; i++){
      int x;
      std::cin>> x;
      A.push_back(x);
   }
   for(int i=0; i<N; i++){
      int x;
      std::cin>> x;
      B.push_back(x);
   }

   std::vector<int> tempA(N, 0), tempB(N, 0);
   std::copy(A.begin(), A.end(), tempA.begin());
   std::copy(B.begin(), B.end(), tempB.begin());

   std::sort(tempB.begin(), tempB.end());
   std::sort(tempA.begin(), tempA.end());
   std::sort(tempA.rbegin(), tempA.rend());

   int answer=0;

   for(int i=0; i<N; i++){
      answer += tempA[i]*tempB[i];
   }
   std::cout<< answer << '\n';

   return 0;
}
