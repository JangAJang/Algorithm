#include <iostream>
using namespace std;

bool bigger(int a, int b, int &big){
    if( a == b) {
        cout << "the numbers are same !! " << endl;
        return false;
    }
    else if( a > b ) {
        big = a;
        cout << "first one is bigger than the second one, and bigger number is " << big << endl;
        return true;
    }
    else {
        big = b;
        cout << "second one is bigger than the fisrt one, and bigger number is " << big << endl;
        return true;
    }
}

int main(){
    cout << "Type down 2 numbers >> ";
    int a, b, big;
    cin >> a >> b;
    bigger(a, b, big);
    return 0;
}
