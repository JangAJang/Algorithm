#include <iostream>
#include <cstring>
using namespace std;

void combine(string &a1, string &a2, string &a3){
    string tmp;
    tmp.append(a1);
    tmp.append(a2);
    tmp.append(a3);
    a3 = tmp;
}

int main(){
    string text1("I love you"), text2(" very much");
    string text3;
    combine(text1, text2, text3);
    cout << text3 << endl;
    return 0;
}
