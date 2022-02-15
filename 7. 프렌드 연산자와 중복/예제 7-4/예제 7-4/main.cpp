#include <iostream>
using namespace std;

class Power{
    int kick, punch;
public:
    Power(int kick = 0, int punch = 0){
        this->kick = kick; this->punch = punch;
    }
    void show();
    Power operator+ (Power op2);
};

void Power::show(){
    cout << "kick >> " << kick << ", punch >> " << punch << endl;
}

Power Power::operator+(Power op2){
    Power tmp;
    tmp.kick = this->kick + op2.kick;
    tmp.punch = this->punch + op2.punch;
    return tmp;
}

int main(){
    Power a(3, 4), b(4, 5), c;
    c = a+b;
    a.show();
    b.show();
    c.show();
}
