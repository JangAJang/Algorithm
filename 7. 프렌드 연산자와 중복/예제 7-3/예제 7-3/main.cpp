#include <iostream>
using namespace std;

class Rect;
class RectManager{
public:
    bool equals(Rect r, Rect s);
    void copy(Rect& des, Rect& src);
};

class Rect{
    int width, height;
public:
    Rect(int width, int height) { this->width = width; this->height = height; }
    friend RectManager;
};

bool RectManager::equals(Rect r, Rect s){
    if(r.width == s.width && r.height == s.height) return true;
    else return false;
}

void RectManager::copy(Rect& des, Rect& src){
    des.width = src.width;
    des.height = src.height;
}

int main(){
    Rect a(3, 4), b(4, 5);
    RectManager man;
    man.copy(a, b);
    if(man.equals(a, b)) cout << "They are same" << endl;
    else cout << "They are different" << endl;
    
}
