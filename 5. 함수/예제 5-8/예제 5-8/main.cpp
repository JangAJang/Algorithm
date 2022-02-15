#include <iostream>
using namespace std;

char& find(char s[], int index){
    return s[index];
}

int main(){
    char name[] = "Mike";
    cout << name << endl;
    find(name, 0) = 'S';
    cout << name << endl;
    char &f = find(name, 2);
    f = 't';
    cout << name << endl;
    return 0;
}
