#include <iostream>
using namespace std;

class Power{
    int kick, punch;
public:
    Power(int kick=0, int punch=0){ this->kick = kick; this->punch = punch; }
    void show();
    Power& operator++ ();
};

void Power::show(){
    cout << "Kick >> " << kick << ", Punch >> " << punch << endl;
}

Power& Power::operator++(){
    kick++;
    punch++;
    return *this;
}

int main(){
    Power a(3, 5), b;
    a.show();
    b.show();
    b = ++a;
    a.show();
    b.show();
}
