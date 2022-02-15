#include <iostream>
#include <cstring>
using namespace std;

int main(){
    char pass[30], word[30];
    cout<<"비밀번호를 입력하시오>>";
    cin>>pass;
    cout<<"비밀번호를 다시 입력하시오>>";
    cin>>word;
    if(strcmp(pass, word) == 0) cout<<"같습니다\n";
    else cout<<"같지 안습니다\n";
    return 0;
}
