#include <iostream>

using namespace std;

class Circle{
    public:
        int radius;
        Circle();
        Circle(int r);
        double getArea();
};

Circle::Circle(){
    radius = 1;
    cout<<"반지름 "<< radius<< "원 생성" <<endl;
}

Circle::Circle(int r){
    radius = r;
    cout<<"반지름 "<< radius <<"원 생성"<< endl;
}

double Circle::getArea(){
    return 3.14*radius*radius;
}

int main(){
    Circle donut;
    double area = donut.getArea();
    cout<<"donut의 면적은 "<< area << "입니다." << endl;
    int r=0;
    cout<<"피자의 반지름을 입력 하시오>> ";
    cin>>r;
    Circle pizza(r);
    cout<<"피자의 면적은 "<< pizza.getArea() << "입니다. "<< endl;
    return 0;
}
