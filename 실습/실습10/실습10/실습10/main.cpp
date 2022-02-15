#include <iostream>
#include <cstring>

using namespace std;

int main(){
    char word[30];
    cout<<"문자열 입력>>";
    cin>>word;
    for(int c=0; word[c] != 0; c++){
        for(int d=0; d<=c; d++){
            cout<<word[d];
        }
        cout<<endl;
    }
    return 0;
}
