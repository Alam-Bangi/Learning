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
    for (int i=2; i<=n; i++) {
        bool isiPrime= checkPrime(i);
        if (isiPrime) {
            cout<< i <<" ";
        }
    }
    
    return 0;
}