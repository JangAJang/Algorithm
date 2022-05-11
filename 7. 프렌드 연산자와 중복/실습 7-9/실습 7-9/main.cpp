#include <iostream>
using namespace std;

class Circle{
    int radius;
public:
    Circle(int radius = 0) { this-> radius = radius; }
    void show(){ cout << "The radius is" << radius << endl;  }
    friend Circle& operator+(int x, Circle& a);
};

Circle& operator+(int x, Circle& a){
    Circle tmp = a;
    tmp.radius = x + a.radius;
    return tmp;
}

int main(){
    Circle a(5), b(4);
    b = 1+a;
    a.show();
    b.show();
}
