#include <iostream>
#include <cstring>
using namespace std;

class Point{
    int x, y;
public:
    Point(int x=0, int y=0) { this->x = x; this->y = y;}
    int getX() { return x; }
    int getY() { return y; }
    void setPoint(int x, int y) {this->x = x; this->y = y;}
    void show() { cout << '(' << x << ',' << y << ')'; }
protected:
    void move(int x, int y) { this-> x = x; this->y = y;}
};

class ColorPoint : public Point{
    string color;
public:
    ColorPoint(int x, int y, string color){ this->color = color; setPoint(x, y); }
    void setColor(string color){ this->color = color; }
    void showColorPoint() {
        cout << "Point named " << '"' << color << '"' << "is located on";
        show();
        cout << endl;
    }
};

int main(){
    ColorPoint cp(5, 5, "RED");
    cp.setPoint(10, 20);
    cp.setColor("BLUE");
    cp.showColorPoint();
}
