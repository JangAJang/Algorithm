#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    cout << "아래에 한 줄을 입력하세요.(exit를 입력하면 종료합니다.) "<<endl << ">>";
    while(true){
        
        getline(cin, s, '\n');
        if(s.compare("exit") == 0 ) break;
        int a =s.length();
        for(int i = a-1; i >=0; i--){
            cout << s[i];
        }
        cout << endl << ">>";
    }
    return 0;
}
