#include <iostream>
using namespace std;

class MyIntStack{
    int p[10];
    int tos;
public:
    MyIntStack();
    bool push(int n);
    bool pop(int &n);
    void write(int a, int n);
    void erase(int a);
};

void MyIntStack::write(int a, int n){
    p[a] = n;
}

void MyIntStack::erase(int a){
    p[a] = 0;
}

MyIntStack::MyIntStack(){
    tos = 0;
}

bool MyIntStack::push(int n){
    tos++;
    if (tos == 11) return false;
    write(tos-1, n);
    return true;
}

bool MyIntStack::pop(int &n){
    tos--;
    if(tos == 0) return false;
    n = p[tos];
    write(tos, 0);
    return true;
}

int main(){
    MyIntStack a;
    for(int i=0; i <11; i++){
        if(a.push(i)) cout << i << ' ';
        else cout << endl << i+1 << "stack full"<< endl;
    }
    int n;
    for(int i=0; i<11; i++){
        if(a.pop(n)) cout << n << ' ';
        else cout << endl << i+1 << "stack empty" << endl;
    }
    cout << endl;
    return 0;
}
