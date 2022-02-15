#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    
    cout<<"아래에 문자열을 입력하세요. 빈칸이 있어도 됩니다. (한글 ㄴㄴ링)" <<endl;
    getline(cin, s, '\n');
    int len = s.size();
    
    for(int i=0; i<len; i++){
        string first = s.substr(0.1);
        string sub = s.substr(1, len-1);
        s = sub + first;
        cout << s << endl;
    }
    return 0;
}
