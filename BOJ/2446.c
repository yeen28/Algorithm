#include <stdio.h>

int main(){
	int n;
	scanf("%d", &n);

	for(int i=0; i<n; i++){
		for(int j=0; j<i; j++){
			printf(" ");
		}
		
		//for(int j=n; j>i; j--){ // ok
		for(int j=i; j<n; j++){ // ok
			printf("*");
		}
		for(int j=i; j<n-1; j++){ // ok
			printf("*");
		}
		
		printf("\n");
	}
	
	for(int i=1; i<n; i++){
		for(int j=i; j<n-1; j++){ // ok
			printf(" ");
		}
		
		for(int j=0; j<=i; j++){
			printf("*");
		}
		for(int j=0; j<i; j++){
			printf("*");
		}
		
		printf("\n");
	}
	
	return 0;
}
