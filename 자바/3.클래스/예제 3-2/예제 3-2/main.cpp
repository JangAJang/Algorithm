#include <iostream>

using namespace std;

class Rectangle{
public:
    int width, height;
    int getArea();
    
};

int Rectangle::getArea(){
    return width*height;
};

int main(){
    Rectangle rect;
    cout<<"폭과 넓이를 입력하시오.>>";
    cin>>rect.width>>rect.height;
    cout<<"입력하신 직사각형의 넓이는 "<<rect.getArea()<<"입니다. "<<endl;
    return 0;
}
