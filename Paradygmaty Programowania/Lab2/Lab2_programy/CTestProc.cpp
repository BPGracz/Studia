#include <stdio.h>
    
//void proc1();
//void proc2();

void proc2() {
	int y;
	y=x;
	printf("wartosc y = %d", y);
  } 
void proc1() {  	
	int x = 15;
	proc2();	
  }   
    
int main() {
  int x =5;         
   proc1();
   return 0;  
}



  
  
