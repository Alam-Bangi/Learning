#include <iostream>
#include "assert.h"
using namespace std;

int main() {
    int number;
    cin >> number;
    int c=1;
    
    for (int row=0; row<number; row++) {
        for(int col = 0; col<=row; col++) {
            cout<< c<<" ";
            c++;
        }
        cout << endl;
    }
    return 0;
}