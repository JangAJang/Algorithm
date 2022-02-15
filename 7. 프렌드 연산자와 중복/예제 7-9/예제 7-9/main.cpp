#include <iostream>
using namespace std;

class Power{
    int kick, punch;
public:
    Power(int kick = 0, int punch = 0){ this->punch = punch; this->kick = kick; }
    void show();
    bool operator! ();
};

void Power::show(){
    cout << "Kick >> " << kick << ", Punch >> " << punch << endl;
}

bool Power::operator! (){
    if(kick == 0 && punch == 0) return true;
    else return false;
}

int main(){
    Power a(0,0), b(5,5);
    if(!a) cout << "A has 0 Power" << endl;
    else cout << "A has a power" << endl;
    if(!b) cout << "B has 0 power" << endl;
    else cout << "B has a power" << endl;
}
