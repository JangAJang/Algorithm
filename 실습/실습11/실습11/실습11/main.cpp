#include <iostream>
#include <cstring>

using namespace std;

int main(){
    int end, sum=0;
    cout<<"끝 수를 입력하시오>>";
    cin>>end;
    for(int c=0;c<=end;c++){
        sum+=c;
    }
    cout<<"1에서 "<<end<<"까지의 합은 "<<sum<<"입니다.\n";
    return 0;
}
