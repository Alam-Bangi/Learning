#include <iostream>
#include "assert.h"
using namespace std;

int main() {
    int number;
    cin >> number;
    
    
    for (int row=1; row<=number; row++) {
        int c=1;
        for(int col = 1; col<=row; col++) {
            cout<< c<<" ";
            c=c*(row-col)/col;
        }
        cout << endl;
    }
    return 0;
}