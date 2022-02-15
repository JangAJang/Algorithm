#include <iostream>

using namespace std;

class Color{
    int red, blue, green;
public:
    Color(){red = blue = green =1;}
    Color(int r, int b, int g){ red = r; blue = b; green = g;}
    void setColor(int r, int b, int g){ red = r; blue = b; green = g;}
    void show(){ cout << red << ' ' << blue << ' ' << green << ' '<< endl;}
};

int main(){
    Color screen(255, 0, 0);
    Color *p;
    p = &screen;
    p->show();
    Color colors[3];
    p = colors;
    p->setColor(255, 0, 0);
    (p+1)->setColor(0, 255, 0);
    (p+2)->setColor(0, 0, 255);
    
    for(int i=0; i<3; i++){
        (p+i)->show();
    }
    return 0;
}
