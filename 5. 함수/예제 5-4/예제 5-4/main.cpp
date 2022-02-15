#include <iostream>
using namespace std;

class Circle{
    int radius;
public:
    Circle(){radius =1;}
    Circle(int radius) {this->radius = radius;}
    void setRadius(int radius) {this->radius = radius;}
    double getArea() {return 3.14*radius*radius;}
};

int main(){
    Circle circle;
    Circle &refn = circle;
    refn.setRadius(10);
    cout << refn.getArea() << " " << circle.getArea() << endl;
    return 0;
}
