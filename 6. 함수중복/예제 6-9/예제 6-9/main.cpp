#include <iostream>
#include <cstring>
using namespace std;

void msg(int id){
    cout << id << endl;
}

void msg(int id, string s = ""){
    cout << id << ":" << s;
}

int main(){
    msg(5, "Good Morning");
    msg(6);
}
