#include <iostream>

using namespace std;

#include "Exp.h"

int main(){
    Exp a(3, 2);
    Exp b(9);
    Exp c;
    
    cout << a.getValue() << ' ' << b.getValue() << ' ' << c.getValue() << endl;
    cout << "a base" << a.getBase() << ',' << "Exp is " << a.getExp() << endl;
    
    if(a.equals(b)) cout << "same" << endl;
    else cout << "not same" << endl;
}
