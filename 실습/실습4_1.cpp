#include <iostream>

using namespace std;

int main(){
    float a[5], max;
    int c;
    cout<<"5개의 실수를 입력하시오 >>";
    for(c=0; c<5;c++){
        cin>>a[c];
    }
    max = a[0];
    for(c=1;c<5;c++){
        if(max<a[c]) max = a[c];
    }
    return 0;
}