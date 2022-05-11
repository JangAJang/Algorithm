#include <iostream>
using namespace std;

int add(int *a, int count, int *b = NULL){
    int sum =0;
    for(int i=0; i< count; i++){
        sum += a[i];
        if(b != NULL)
            sum += b[i];
    }
    return sum;
}

int main(){
    int a[] = {1, 2, 3,4 , 5};
    int b[] = {6, 7, 8, 9, 10};
    int c = add(a, 5);
    int d = add(a, 5, b);
    cout << c << endl << d << endl;
}
