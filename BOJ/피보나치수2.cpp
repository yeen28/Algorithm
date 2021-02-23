#include <iostream>

void fibonacci(int n){
	long long arr[95] = {};
	arr[0] = 0;
	arr[1] = 1;
	
	for(int i=2; i<=n; i++){
		arr[i] = arr[i-1] + arr[i-2];
	}
	std::cout<<arr[n]<<'\n';
}

int main(){
	int n;
	std::cin>>n;
	
	fibonacci(n);
	
	return 0;
}
