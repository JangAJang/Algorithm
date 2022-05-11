#include <iostream>
using namespace std;

class Circle{
    int radius;
public:
    Circle() {radius = 1;}
    Circle(int radius) { this->radius = radius;}
    double getArea(){return 3.14*radius*radius;}
    int getRadius(){return radius;}
    void setRadius(int radius) { this->radius = radius;}
};

void readRadius(Circle &c){
    int r;
    cout << "type the radius -> ";
    cin >> r;
    c.setRadius(r);
}

int main(){
    Circle donut;
    readRadius(donut);
    cout << "Area of donut is " << donut.getArea() << endl;
    return 0;
}
