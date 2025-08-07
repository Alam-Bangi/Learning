#include <iostream>
#include "assert.h"
using namespace std;

int main() {
    int number;
    cin >> number;
    int c=1;
    
    for (int row=0; row<number; row++) {
        int cond = row<=2 ? 2*row : 2*(number-row-1);
        for (int col=0; col<=cond; col++) {
            if (col<=cond/2) {
                cout << col+1;
            } else {
                cout << cond-col+1;
            }
        }
        cout << endl;
    }
    return 0;
}