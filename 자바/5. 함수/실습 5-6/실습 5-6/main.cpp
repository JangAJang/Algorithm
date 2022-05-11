#include <iostream>
#include <cstring>
using namespace std;

char& find(char a[], char c, bool& success){
    int i;
    for(i=0; i<4 ; i++){
        if(a[i] == c) {
            success = true;
            break;
        }
    }
    char& dest = a[i];
    return dest;
}

int main(){
    char s[] = "Mike";
    bool b = false;
    char& loc = find(s, 'M', b);
    if(b == false ){
        cout << "can't find M" << endl;
        return 0;
    }
    loc  = 'm';
    cout << s << endl;
    return 0;
}
