#include <iostream>
using namespace std;

class Circle{
    int radius;
public:
    Circle();
    Circle(int radius);
    ~Circle();
    double getArea(){return 3.14*radius*radius;}
    int getRadius() { return radius; }
    void setRadius(int radius) { this->radius = radius; }
};

Circle::Circle(){
    radius = 1;
    cout << "Constructor Operated, radius = " << radius << endl;
}

Circle::Circle(int radius){
    this->radius = radius;
    cout << "Constructor Operated, radius = " << radius << endl;
}

Circle::~Circle(){
    cout << "Destructor Operated, radius = " << radius << endl;
}

void increase(Circle &c){
    int r = c.getRadius();
    c.setRadius(r+1);
}

int main(){
    Circle waffle(30);
    increase(waffle);
    cout << waffle.getRadius() << endl;
    return 0;
}
