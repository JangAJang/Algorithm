#include <iostream>
using namespace std;

class Power{
    int kick, punch;
public:
    Power(int kick = 0, int punch = 0){
        this->kick = kick; this->punch = punch;
    }
    void show(){
        cout << "Kick >> " << kick << ", Punch >> " << punch << endl;
    }
    friend Power operator+(int op1, Power op2);
    
};

Power operator+(int op1, Power op2){
    Power tmp;
    tmp.kick = op1 + op2.kick;
    tmp.punch = op1 + op2.punch;
    return tmp;
}

int main(){
    Power a(3, 5), b;
    a.show();
    b.show();
    b = 2+a;
    a.show();
    b.show();
}
