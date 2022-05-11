#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    cout <<"문자열 입력 >> ";
    getline(cin, s, '\n');
    int indexer = 0, counter = 0, starter = 0;
    while(true){
        int indexer = s.find('a', starter);
        if(indexer == -1) break;
        counter++;
        starter = indexer+1;
    }
    cout<<"a = " << counter << endl;
    return 0;
}
