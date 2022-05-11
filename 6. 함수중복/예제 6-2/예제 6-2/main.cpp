#include <iostream>
using namespace std;

int sum(int a, int b){
    int sum=a;
    for(int i=a; i<=b; i++){
        sum +=a;
    }
    return sum;
}

int sum(int a){
    int s=0;
    for(int i=0; i<a+1; i++){
        s+=i;
    }
    return s;
}

int main(){
    cout << sum(3, 5) << endl;
    cout << sum(3) << endl;
    cout << sum(100) << endl;
}
