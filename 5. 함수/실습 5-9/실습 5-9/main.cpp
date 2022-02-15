#include <iostream>
using namespace std;

class Accumulator{
    int value;
public:
    Accumulator(int value){ this->value = value; }
    Accumulator& add(int n);
    int get(){return value;}
};

Accumulator& Accumulator::add(int n){
    this->value += n;
    return *this;
}

int main(){
    Accumulator acc(10);
    acc.add(5).add(6).add(7);
    cout << acc.get()<< endl;
    return 0;
}
