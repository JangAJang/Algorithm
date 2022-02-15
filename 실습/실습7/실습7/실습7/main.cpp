#include <iostream>
#include <cstring>

using namespace std;

int main(){
    char off[100];
    cout<<"종료하고 싶으면 yes를 입력하세요>>";
    cin.getline(off,100,'\n');
    while(true){
        if(strcmp(off, "yes") ==0){
            cout<<"종료합니다\n";
                break;
        }
        else {
            cout<<"종료하고 싶으면 yes를 입력하세요>>";
            cin.getline(off,100,'\n');
        }
    };
    return 0;
}
