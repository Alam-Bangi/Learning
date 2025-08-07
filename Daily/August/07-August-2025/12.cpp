#include <iostream>
#include "assert.h"
using namespace std;

bool checkPrime(int n) {
    for (int i =2; i<n; i++) {
        if(n%i==0) {
            return false;
        } 
    }
    return true;
}

int main() {
    int n;
    cout<<"Enter number: ";
    cin >> n;
    bool isPrime= checkPrime(n);
    if (isPrime) {
        cout<<"Prime";
    } else {
        cout<<"Not a prime";
    }
    
    return 0;
}