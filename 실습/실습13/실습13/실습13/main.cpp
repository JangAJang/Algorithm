#include <iostream>

using namespace std;

int main(){
    int a=0, b=0;
    cout<<"***** 승리장에 오신 것을 환영합니다. *****\n";
    while(a!=4){
        cout<<"짬뽕:1, 짜장:2, 군만두:3, 종료:4>>\n";
        cin>>a;
        if(a==4) break;
        else if(a>4) cout<<"다시 주문하세요!!\n";
        else {
            cout<<"몇인분?";
            cin>>b;
            if(a==1){
                cout<<"짜장 "<<b<<"인분 나왔습니다\n";
            }
            else if(a==2){
                cout<<"짬뽕 "<<b<<"인분 나왔습니다\n";
            }
            else{
                cout<<"탕수육 "<<b<<"인분 나왔습니다\n";
            }
            
        }
    }
    cout<<"오늘 영업은 끝났습니다.\n";
    return 0;
}
