#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    cout << "여러줄의 문자열을 입력하세요. 입력의 끝은 &문자입니다. "<<endl;
    getline(cin, s, '&');
    cin.ignore();
    
    string f, r;
    cout << "find : " ;
    getline(cin, f, '\n');
    cout << "replace : ";
    getline(cin, r, '\n');
    
    int counter=0;
    while(true){
        int address = s.find(f);
        if(address == -1) break;
        s.replace(address, f.length(), r);
        counter = address + r.length();
    }
    cout << s << endl;
    return 0;
}
