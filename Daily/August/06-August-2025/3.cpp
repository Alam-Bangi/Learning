// Online C++ compiler to run C++ program online
#include <iostream>
#include <math.h>
using namespace std;

int binaryToDecimal(int number) {
    int decimal=0;
    int i=0;
    while (number) {
        int bit= number%10;
        decimal= decimal+bit*pow(2, i++);
        number = number/10;
    }
    return decimal;
}

int main() {
    int number;
    cout << "Enter binary number: ";
    cin>>number;
    cout << "Decimal number: " << binaryToDecimal(number)<<endl;
    
    return 0;
}