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
    cout << "반지름 1인 원 생성"<< endl;
}

Circle::Circle(int r){
    radius = r;
    cout << "반지름 " << r << "인 원 생성" << endl;
}

Circle::~Circle(){
    cout << "반지름"<< radius <<"원 소멸"<<endl;
}

double Circle::getArea(){
    return 3.14 * radius * radius;
}

int main(){
    Circle c1;
    Circle c2;
    cout << "반지름을 입력하시오. ";
    cin >> c2.radius;
    return 0;
}
