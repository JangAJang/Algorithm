#include <iostream>

using namespace std;

class Circle{
public:
    int radius;
    Circle();
    Circle(int r);
    double getArea();
};

Circle::Circle() : Circle(1){}


Circle::Circle(int r){
    radius = r;
    cout<< "반지름 " << radius << " 원 생성" << endl;
}

double Circle::getArea(){
    return radius*radius*3.14;
}

int main(){
    Circle donut;
    cout<<"도넛의 면적은 " << donut.getArea() << "입니다." << endl;
    Circle pizza(30);
    cout<<"피자의 면적은 " << pizza.getArea() << "입니다." << endl;
    return 0;
}
