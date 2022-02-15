#include <iostream>
using namespace std;

class Adder{
protected:
    int add(int a, int b){ return a+b; }
};

class Subtractor{
protected:
    int sub(int a, int b) { return a-b; }
};

class Calculator : public Adder, public Subtractor{
public:
    int calc(char op, int a, int b);
};

int Calculator::calc(char op, int a, int b){
    int res = 0;
    switch(op){
        case '+' : res = add(a, b); break;
        case '-' : res = sub(a, b); break;
    }
    return res;
}

int main(){
    Calculator hand;
    cout << "2 + 4 = " << hand.calc('+', 2, 4) << endl;
    cout << "100 - 8 = " << hand.calc('-', 100, 8) << endl;
}
