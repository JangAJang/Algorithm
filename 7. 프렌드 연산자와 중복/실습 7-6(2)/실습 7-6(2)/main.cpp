#include <iostream>
using namespace std;

class Matrix{
    int a[4];
public:
    Matrix(int a=0, int b=0, int c=0, int d=0) {
        this->a[0] = a; this->a[1] = b; this->a[2] = c; this->a[3] = d; }
    void show(){
        cout << "Matrix = {";
        for(int i=0; i<4; i++){
            cout << ' ' << a[i];
        }
        cout << " }" << endl;
    }
    friend Matrix operator+(Matrix x, Matrix y);
    friend Matrix& operator+=(Matrix& x, Matrix y);
    friend bool operator==(Matrix x, Matrix y);
};

Matrix operator+(Matrix x, Matrix y){
    Matrix tmp;
    for(int i=0; i<4; i++){
        tmp.a[i] = x.a[i] + y.a[i];
    }
    return tmp;
}

Matrix& operator+=(Matrix &x, Matrix y){
    for(int i=0; i<4; i++){
        x.a[i] += y.a[i];
    }
    return x;
}

bool operator==(Matrix x, Matrix y){
    Matrix tmp;
    for(int i=0; i<4; i++){
        if(x.a[i] != y.a[i]) return false;
    }
    return true;
}



int main(){
    Matrix a(1, 2, 3, 4), b(2, 3, 4, 5), c;
    c = a+b;
    a += b;
    a.show();b.show();c.show();
    if(a == c) cout << "A and C are same" << endl;
}
