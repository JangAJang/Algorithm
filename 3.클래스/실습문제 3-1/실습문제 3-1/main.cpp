#include <iostream>

using namespace std;

class Tower{
private:
    int height;
public:
    Tower();
    Tower(int h);
    int getHeight();
};

Tower::Tower(){
    height = 1;
};

Tower::Tower(int h){
    height = h;
};

int Tower::getHeight(){
    return height;
}

int main(){
    Tower myTower;
    Tower SeoultTower(100);
    cout << myTower.getHeight() << endl;
    cout << SeoultTower.getHeight() << endl;
    return 0;
}
