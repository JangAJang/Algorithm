#include <iostream>

using namespace std;

class Circle{
public:
    int radius;
    double getArea();
    Circle(int r);
};

Circle::Circle(int r){
    radius = r;
}

int main(){
    Circle coin(3);
    return 0;
}
