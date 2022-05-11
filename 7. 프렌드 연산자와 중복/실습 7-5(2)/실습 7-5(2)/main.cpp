#include <iostream>
using namespace std;

class Color{
    int red, blue, green;
public:
    Color(int red=0, int green=0, int blue=0){this->red = red; this->green = green; this->blue = blue;}
    void show(){ cout << red << ' ' << green << ' ' << blue << endl; }
    friend Color operator+(Color& a, Color& b);
    friend bool operator==(Color& a, Color& b);
};


Color operator+(Color& a, Color& b){
    Color tmp;
    tmp.red = a.red + b.red;
    tmp.blue = a.blue + b.blue;
    tmp.green = a.green + b.green;
    return tmp;
}

bool operator==(Color&a, Color& b){
    if(a.red == b.red && a.green == b.green && a.blue == b.blue) return true;
    else return false;
}

int main(){
    Color red(255, 0, 0), blue(0, 0, 255), c;
    c = red + blue;
    c.show();
    Color fuchsia(255, 0, 255);
    if(c== fuchsia) cout << "It's purple" << endl;
    else cout << "It's not purple" << endl;
}
