#include <iostream>
using namespace std;

class ArrayUtility{
    int *array1;
    double *array2;
    int size;
public:
    ArrayUtility();
    static void intoDouble(int source[], double dest[], int size);
    static void intoInt(double source[], int dest[], int size);
};

void ArrayUtility::intoDouble(int source[], double dest[], int size){
    for(int i=0; i< size; i++) dest[i] = (double)source[i];
}

void ArrayUtility::intoInt(double source[], int dest[], int size){
    for(int i=0; i< size; i++) dest[i] = (int)source[i];
}

int main(){
    int x[] = {1, 2, 3, 4, 5};
    double y[5];
    double z[] = {9.9, 8.8, 7.7, 6.6, 5.6};
    ArrayUtility::intoDouble(x, y, 5);
    for(int i=0; i<5; i++) cout << y[i] << ' ';
    cout << endl;
    ArrayUtility::intoInt(z, x, 5);
    for(int i=0; i<5; i++) cout << x[i] << ' ';
    cout << endl;
}
