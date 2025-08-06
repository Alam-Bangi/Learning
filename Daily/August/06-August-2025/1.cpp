// Online C++ compiler to run C++ program online
#include <iostream>
#include <math.h>

using namespace std;

int decimalToBinary(int number) {
    int binaryno =0;
    int i=0;
    while (number>0) {
        int bit = number&1;
        cout<<bit<<endl;
        binaryno = bit*pow(10, i++)+binaryno;
        number=number>>1;
    }
    return binaryno;
}

int main() {
    int number;
    cin>>number;
    int binary = decimalToBinary(number);
    cout<< binary << endl;

    return 0;
}