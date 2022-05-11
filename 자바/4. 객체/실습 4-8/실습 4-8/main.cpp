#include <iostream>
using namespace std;

class Circle{
    int radius;
public:
    void setRadius(int radius);
    double getArea(){ return 3.14 * radius * radius;}
};

void Circle::setRadius(int r) { radius = r;}

int main(){
    int c, r, counter = 0;
    cout << "원의 개수 >> ";
    cin >> c;
    Circle circles[c];
    for(int i = 0; i < c; i++){
        cout << "원 "<< i+1 << "반지름 >> ";
        cin >> r;
        circles[i].setRadius(r);
        if(circles[i].getArea() > 100) counter++;
    }
    cout << "면적이 100보다 큰 원의 개수는 " << counter <<"개 입니다. " <<endl;
    return 0;
};
