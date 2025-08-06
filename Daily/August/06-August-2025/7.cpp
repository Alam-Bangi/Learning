// Online C++ compiler to run C++ program online
#include <iostream>
using namespace std;

int main() {
    int number;
    cin >> number;
    
    for (int row=0; row<number; row++) {
        for (int col=0; col<number-row; col++) {
            cout << "*";
        } 
        cout<<endl;
    }
    
    for (int row=0; row<number; row++) {
        for (int col=0; col<number-row; col++) {
            if(row==0 || col==0 || col==number-row-1) {
                cout << "*";
            } else {
                cout<< " ";
            }
        }
        cout<<endl;
    }
    
    for (int row=0; row<number; row++) {
        for (int col=0; col<number-row; col++) {
            if(row==0 || col==0 || col==number-row-1) {
                cout << col+1;
            } else {
                cout<< " ";
            }
        }
        cout<<endl;
    }
    char ch='A';
    for (int row=0; row<number; row++) {
        for (int col=0; col<number-row; col++, ch++) {
            if(row==0 || col==0 || col==number-row-1) {
                cout << (char)ch;
            } else {
                cout<< " ";
            }
        }
        ch='A';
        cout<<endl;
    }
    
    return 0;
}