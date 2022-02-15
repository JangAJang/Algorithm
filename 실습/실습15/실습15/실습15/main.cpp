#include <iostream>
#include <cstring>

using namespace std;

int main(){
    char a[10], b[10], cal;
    int re=0;
    while(true){
    cout<<"? ";
    cin>>a>>cal>>b;
    if(cal == '+') re = atoi(a) + atoi(b);
    if(cal == '-') re = atoi(a) - atoi(b);
    if(cal == '*') re = atoi(a) * atoi(b);
    if(cal == '/') re = atoi(a) / atoi(b);
    if(cal == '%') re = atoi(a) % atoi(b);
    cout<<a<<" "<<cal<<" "<<b<< " = "<< re<<endl;
    }
    return 0;
}
