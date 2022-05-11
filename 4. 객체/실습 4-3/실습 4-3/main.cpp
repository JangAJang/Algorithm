#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    cout << "문자열을 입력하시오. ";
    getline(cin, s, '\n');
    int counter =0;
    int n = s.length();
    for(int i=0; i< n; i++){
        if(s.at(i) == 'a') counter ++;
    }
    cout << "a는 " << counter << "개 있습니다. " <<endl;
    return 0;
}
