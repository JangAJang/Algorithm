#include <iostream>
using namespace std;

class Circle{
    int radius;
public:
    Circle() { radius = 1; }
    Circle(int radius) { this->radius = radius;}
    ~Circle() { }
    double getArea(){ return 3.14*radius*radius; }
    int getRadius(){ return radius;}
    void setRadius(int radius) { this->radius = radius; }
};

void swap(Circle &c){
    Circle tmp;
    c.setRadius(tmp.getRadius());
}

int main(){
    Circle a;
    Circle b(30);
    cout << a.getRadius() << '\t' << b.getRadius() << endl;
    swap(b);
    cout << a.getRadius() << '\t' << b.getRadius() << endl;
    return 0;
}
