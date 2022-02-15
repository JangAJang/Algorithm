#include <iostream>
#include <cstring>
#include <cstdlib>
#include <ctime>
using namespace std;

int main(){
    string s;
    while(true){
        cout << "아래 한 줄을 입력하시오. " << endl << ">> ";
        getline(cin, s, '\n');
        if(s.compare("exit") == 0) break;
        srand((unsigned)time(0));
        int n = rand() % s.length();
        s[n] = 'a' + rand() %26;
        cout << s << endl;
    }
    return 0;
}
