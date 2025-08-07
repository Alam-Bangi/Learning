#include <iostream>
using namespace std;

int main() {
    int number;
    cin >> number;
    
    for (int row=0; row<2*number-1; row++) {
        int cond=i<n? i: n-(i%n)-2;
        for (int col=0; col<=cond; col++) {
            cout <<"*";
        }
        cout<<endl;
    }      
    return 0;
}