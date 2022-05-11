#include <iostream>
#include <string>

using namespace std;

class Integer{
    int num;
public:
    Integer(int n);
    Integer(string b);
    int get();
    bool isEven();
    void set(int x);
};

Integer::Integer(int n){
    num = n;
}

Integer::Integer(string b){
    num = stoi(b);
}

int Integer::get(){
    return num;
}

bool Integer::isEven(){
    if(num % 2 == 0) return true;
    else return false;
}

void Integer::set(int x){
    num = x;
}

int main(){
    Integer n(30);
    cout << n.get() << ' ';
    n.set(50);
    cout << n.get() << ' ';
    
    Integer m("300");
    cout << m.get() << ' ';
    cout << m.isEven();
}
