#include <iostream>
#include "assert.h"
using namespace std;

float areaOfCircle(float r) {
    // cin<< r;
    float area= 3.14*r*r;
    return area;
}
int main() {
    float r;
    cout<<"Enter radius: ";
    cin>>r;
    cout << "Area of Circle is : " << areaOfCircle(r);
    return 0;
}