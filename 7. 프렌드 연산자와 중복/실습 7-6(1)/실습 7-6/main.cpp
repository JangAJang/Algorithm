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
    Matrix operator+(Matrix& b);
    Matrix operator+=(Matrix& b);
    bool operator==(Matrix& c);
};

Matrix Matrix::operator+(Matrix& b){
    Matrix tmp;
    for(int i=0; i<4; i++){
        tmp.a[i] = this->a[i] + b.a[i];
    }
    return tmp;
}

Matrix Matrix::operator+=(Matrix& b){
    for(int i=0; i<4; i++){
        this->a[i] += b.a[i];
    }
    return *this;
}

bool Matrix::operator==(Matrix &c){
    for(int i=0; i<4; i++){
        if(this->a[i] != c.a[i]) return false;
    }
    return true;
}

int main(){
    Matrix a(1, 2, 3, 4), b(2, 3, 4, 5), c;
    c = a + b;
    a += b;
    a.show();b.show();c.show();
    if(a==c) cout << "A and C are same" << endl;
}
