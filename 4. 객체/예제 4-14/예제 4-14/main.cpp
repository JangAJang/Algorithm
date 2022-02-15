#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    cout << "7+23+100+25와 같이 덧셈 문자열을 입력하시오." <<endl;
    getline(cin, s, '\n');
    int sum = 0, indexer = 0;
    while(true){
        int fIndex = s.find('+', indexer);
        if(fIndex == -1){
            string part = s.substr(indexer);
            if(part == "") break;
            cout << part << endl;
            sum += stoi(part);
            break;
        }
        int count = fIndex - indexer;
        string part = s.substr(indexer, count);
        cout << part << endl;
        sum += stoi(part);
        indexer = fIndex + 1;
    }
    cout << "sum = " << sum << endl;
    return 0;
}
