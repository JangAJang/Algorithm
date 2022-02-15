#include <iostream>
using namespace std;

class Power{
    int kick, punch;
public:
    Power(int kick = 0, int punch = 0) { this ->kick = kick; this->punch = punch; }
    void show();
    Power operator++ (int x);
};

void Power::show(){ cout << "Kick >> " << kick << ", Power >> " << punch << endl; }

Power Power::operator++(int x){
    Power tmp = *this;
    kick++;
    punch++;
    return tmp;
}

int main(){
    Power a(3, 4), b;
    a.show();
    b.show();
    b = a++;
    a.show();
    b.show();
}
