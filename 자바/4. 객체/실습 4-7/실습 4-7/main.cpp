#include <iostream>
using namespace std;

class Circle{
    int radius;
public:
    void setRadius(int radius);
    double getArea() {return 3.14 * radius * radius;}
};

void Circle::setRadius(int r){
    radius = r;
}

int main(){
    Circle circles[3];
    int counter = 0, radius = 0;
    for(int i = 0; i<3; i++){
        cout << "원 " << i+1 << "의 반지름 >> ";
        cin >> radius;
        circles[i].setRadius(radius);
        if(circles[i].getArea() > 100) counter++;
    }
    cout << "면적이 100보다 큰 원은 " << counter << "개 입니다. " << endl;
    return 0;
}
