#include<iostream>
using namespace std;
 
class Statistics{
    int *a;
    int cnt; //배열의 원소 개수
public:
    Statistics() { a = new int[8]; cnt=0; }
    
    bool operator! (){
        if( this->a && this->cnt==0) return true;
        return false;
    }
    
    Statistics& operator<< (int num){
        this->a[cnt] = num;
        cnt ++;
        return *this;
    }
    void operator~ (){
        for(int i=0; i<cnt; i++)
            cout << this->a[i] << ' ';
        cout << endl;
    }
    void operator>> (int& avg){
        avg = 0;
        for(int i=0; i<cnt; i++)
            avg += a[i];
         avg /= cnt;
    }
    ~Statistics(){
        delete [] a;
    }
};
 
int main() {
    Statistics stat;
    if(!stat) cout << "현재 통계 데이타가 없습니다." << endl;
    
    int x[5];
    cout << "5 개의 정수를 입력하라>>";
    for(int i=0; i<5; i++) cin >> x[i]; // x[i]에 정수 입력
    
    for(int i=0; i<5; i++) stat << x[i]; // x[i] 값을 통계 객체에 삽입한다.
    stat << 100 << 200; // 100, 200을 통계 객체에 삽입한다.
    ~stat; // 통계 데이터를 모두 출력한다.
    
    int avg;
    stat >> avg; // 통계 객체로부터 평균을 받는다.
    cout << "avg=" << avg << endl;  // 평균을 출력한다.
}
 
