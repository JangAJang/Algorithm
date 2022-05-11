#include <iostream>

using namespace std;

class Circle{
    int radius;
public:
    double getArea();
    Circle();
    Circle(int r);
    Circle(short r);
};

int main(){
    Circle waffle;
    Circle pizza(30);
    double d = pizza.getArea();
}
