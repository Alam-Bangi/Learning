#include <iostream>
#include <math.h>

using namespace std;

int decimalToBinary(int number) {
    int binaryno =0;
    int i=0;
    while (number>0) {
        int bit = number%2;
        cout<<bit<<endl;
        binaryno = bit*pow(10, i++)+binaryno;
        number=number/2;
    }
    return binaryno;
}

int main() {
    int number;
    cin>>number;
    // int binary = decimalToBinary(number);
    cout<<decimalToBinary(number) << endl;

    return 0;
}