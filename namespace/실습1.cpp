#include <iostream>

using namespace std;

int main(){
    int a = 0, ten = 0;
    for(; ten <=10;){
        for(; a<=10;){
            a++;
            cout<< 10*ten + a<<"    ";
        }
        cout<<endl;
        ten++;
    }
    return 0;
}