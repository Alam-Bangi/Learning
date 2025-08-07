

#include <iostream>
#include "assert.h"
using namespace std;

bool checkEven(int n) {
    if (n%2==0) {
        return true;
    } else {
        return false;
    }
}
int main() {
    int n;
    cout<<"Enter number: ";
    cin >> n;
    bool isEven = checkEven(n);
    
    if (isEven) {
        cout << "Even number";
    } else {
        cout << "Odd number";
    }
    return 0;
}