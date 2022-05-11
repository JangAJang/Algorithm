#include <iostream>

using namespace std;

class Circle{
    int radius;
public:
    Circle() {radius = 1;};
    Circle(int r) { radius = r;};
    void setRadius(int r) { radius = r;}
    double getArea();
};


double Circle::getArea(){
    return 3.14*radius*radius;
}

int main(){
    Circle circlearray[3];
    circlearray[0].setRadius(10);
    circlearray[1].setRadius(20);
    circlearray[2].setRadius(30);
    for(int i=0; i<3;i++){
        cout << "Circle" << i <<"의 면적은 " << circlearray[i].getArea() << endl;
    }
    
    Circle *p;
    p=circlearray;
    for(int i=0; i<3;i++){
        cout << "Circle "<< i <<"의 면적은 " << p->getArea() << endl;
        p++;
    }
    return 0;
}
