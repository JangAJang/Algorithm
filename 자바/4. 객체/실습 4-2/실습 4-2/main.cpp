#include <iostream>

using namespace std;

int main(){
    int *p = new int [5];
    double sum = 0;
    cout << "정수를 5개 입력하시오 " << endl;
    for(int i=0; i<5; i++){
        cin >> p[i];
        sum += p[i];
    }
    double average = sum/5;
    cout << "average = " << average << endl;
    return 0;
}
