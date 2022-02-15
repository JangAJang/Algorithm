#include <iostream>
using namespace std;

class Power{
    int kick, punch;
public:
    Power(int kick =0, int punch = 0){
        this->kick = kick; this->punch = punch;
    }
    void show();
    bool operator== (Power op2);
};

void Power::show(){
    cout << "kick >> " << kick << ", punch >> " << punch << endl;
}

bool Power::operator== (Power op2){
    if(kick == op2.kick && punch == op2.punch ) return true;
    else return false;
}

int main(){
    Power a(3, 4), b(4, 5), c;
    a.show();
    b.show();
    if( a== b) cout << "Two powers are same" << endl;
    else cout << "Two powers are different" << endl;
}
