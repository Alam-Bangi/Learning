#include <iostream>
#include "assert.h"
using namespace std;

int main() {
    int number;
    cin >> number;
    int c=1;
    
    for (int row=0; row<number; row++) {
        for (int col=0; col<=row; col++) {
            cout <<c;
            c++;
            if(col<row) {
                cout<<"*";
            }
        }
        cout<<endl;
    }      
    // Shrinking phase
    int start = c - number;
    for(int row=0; row<number; row++) {
        int k = start;
        for(int col=0;col<=number-row-1; col++) {
            cout<< k;
            k++;
            if(col<number-row-1) {
                cout<<"*";
            }
        }
        start = start -(number-row-1);
        cout<<endl;
    }
    return 0;
}