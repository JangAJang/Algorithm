#include <iostream>
using namespace std;

class Color{
    int red, blue, green;
public:
    Color(int red=0, int green=0, int blue=0){this->red = red; this->green = green; this->blue = blue;}
    void show(){ cout << red << ' ' << green << ' ' << blue << endl; }
    Color operator+(Color& c);
    bool operator==(Color& c);
};

Color Color::operator+(Color &c){
    this->red += c.red;
    this->blue += c.blue;
    this->green += c.green;
    return *this;
}

bool Color::operator==(Color &c){
    if(this->red == c.red && this->blue == c.blue && this->green == c.green) return true;
    else return false;
}

int main(){
    Color red(255, 0, 0), blue(0, 0, 255), c;
    c = red + blue;
    c.show();
    Color fuchsia(255, 0, 255);
    if( c == fuchsia) cout << "It's purple" << endl;
    else cout << "It's not purple" << endl;
}
