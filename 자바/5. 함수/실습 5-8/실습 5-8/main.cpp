#include <iostream>
using namespace std;

class MyIntStack{
    int *p;
    int size;
    int tos;
public:
    MyIntStack(){};
    MyIntStack(int size);
    MyIntStack(const MyIntStack &s);
    ~MyIntStack(){};
    bool push(int n);
    bool pop(int &n);
};

MyIntStack::MyIntStack(int size){
    tos = 0;
    p = new int [size];
    this->size = size;
}

MyIntStack::MyIntStack(const MyIntStack &s){
    this->p = new int [s.size];
    this->size = s.size;
    this->tos = s.tos;
    for(int i = 0; i< s.tos; i++){
        this->p[i] = s.p[i];
    }
}

bool MyIntStack::push(int n){
    if(tos > size) return false;
    p[tos++] = n;
    return true;
}

bool MyIntStack::pop(int &n){
    if(tos < 0 ) return false;
    n = p[--tos];
    return true;
}

int main(){
    MyIntStack a(10);
    a.push(10);
    a.push(20);
    MyIntStack b = a;
    b.push(30);
    int n;
    a.pop(n);
    cout << "popped number from 'a' is " << n << endl;
    b.pop(n);
    cout << "popped number from 'b' is " << n << endl;
    return 0;
}
