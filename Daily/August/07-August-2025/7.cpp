#include <iostream>
#include "assert.h"
using namespace std;

int main() {
    int number;
    cin >> number;
    
    
    for (int row=0; row<2*number; row++) {
        int cond = row<number ? row : number + (number-row-1);
        int space_count = row<number ? 2*(number-cond-1): row-cond-1 ; 
        for(int col = 0; col<2*number; col++) {
            if(col<=cond) {
                cout<<"*";
            } else if(space_count>0) {
                cout <<" ";
                space_count--;
            } else {
                cout <<"*";
            }
        }
        cout << endl;
    }
    return 0;
}