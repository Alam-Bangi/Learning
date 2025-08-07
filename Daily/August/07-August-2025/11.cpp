#include <iostream>
#include "assert.h"
using namespace std;

int fact(int n) {
    int fact=1;
    for (int i=1; i<=n; i++) {
        fact = fact*i;
    }
    return fact;
}
int main() {
    int n;
    cout<<"Enter number: ";
    cin >> n;
    int ans = fact(n);
    cout<<"Factorial of number is: " << ans << endl;
    return 0;
}