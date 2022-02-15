#include <iostrean>

using namespace std;

int main(){
    char sen[100];
    cout<<"문자들을 입력하라(100글자 미만)";
    cin.getline(sen, 100, '\n');
    int c, x;
    for(c = 0; c<100; c++){
        if(sen[c]=='x') x++;
    }
    cout<<"x의 개수는 "<<x<<endl;
    return 0;
}