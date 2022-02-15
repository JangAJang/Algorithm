#include <iostream>

using namespace std;

class Circle{
public:
    int radius;
    Circle();
    Circle(int r);
    ~Circle();
    double getArea();
};

Circle::Circle(){
    radius = 1;
    cout <<"반지름 " << radius << "인 원 생성"<< endl;
}

Circle::Circle(int r){
    radius = r;
    cout <<"반지름 " << radius << "인 원 생성"<< endl;
}

Circle::~Circle(){
    cout <<"반지름 " << radius << "인 원 소멸"<< endl;
}

double Circle::getArea(){
    return 3.14 * radius * radius;
}

Circle globalDonut(1000);

Circle globalPizza(3000);

void f(){
    Circle fDonut(100);
    Circle fPizza(300);
}

int main(){
    Circle mainDonut;
    Circle mainPizza(3);
    f();
    return 0;
}
