#include <iostream>
using namespace std;

class Stack{
    int *p, size;
public:
    Stack(){ size = 0;}
    Stack& operator<<(int x);
    void operator>>(int &x);
    bool operator!();
};

Stack& Stack::operator<<(int x){
    size++;
    int *tmp = new int [size];
    for(int i=0; i<size-1; i++){
        tmp[i] = p[i];
    }
    tmp[size-1] = x;
    p = tmp;
    return *this;
}

void Stack::operator>>(int &x){
    size--;
    x = p[size];
}

bool Stack::operator!(){
    if(size ==0 ) return true;
    else return false;
}

int main(){
    Stack stack;
    stack << 3 << 5 << 10;
    while(true){
        if(!stack) break;
        int x;
        stack >> x;
        cout << x << ' ';
    }
    cout << endl;
}
