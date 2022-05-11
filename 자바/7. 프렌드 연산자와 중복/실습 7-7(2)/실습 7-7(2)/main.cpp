#include <iostream>
using namespace std;

class Matrix{
    int array[4];
public:
    Matrix(int a=0, int b=0, int c=0, int d=0){
        array[0] = a; array[1] = b; array[2] = c;  array[3] = d;
    }
    friend void operator>>(Matrix& matrix, int x[]);
    friend void operator<<(Matrix& matrix, int x[]);
    void show(){
        for(int i=0; i<4; i++){
            cout << array[i] << ' ';
        }
    }
};

void operator>>(Matrix& matrix, int x[]){
    for(int i=0; i<4; i++){
        x[i] = matrix.array[i];
    }
}

void operator<<(Matrix& matrix, int x[]){
    for(int i=0; i<4; i++){
        matrix.array[i] = x[i];
    }
}



int main(){
    Matrix a(4, 3, 2, 1), b;
    int x[4], y[4] = {1, 2, 3, 4};
    a >> x;
    b << y;
    for(int i=0; i<4; i++) cout << x[i] << ' ';
    cout << endl;
    b.show();
    cout << endl;
}

