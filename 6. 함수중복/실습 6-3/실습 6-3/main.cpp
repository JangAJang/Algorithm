#include <iostream>
using namespace std;

int big(int a, int b, int c=0){
    int big;
    big = a;
    if( b > big ) {
        if ( c > b) big = c;
        else big = b;
    }
    if (big > 100) big = 100;
    return big;
}

int main(){
    int x = big(3, 5);
    int y = big(300, 60);
    int z = big(30, 60, 50);
    cout << x << '\t' << y << '\t' << z << endl;
}
