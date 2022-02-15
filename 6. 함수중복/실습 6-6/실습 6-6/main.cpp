#include <iostream>
using namespace std;

class ArrayUtility2{
public:
    static int* concat(int s1[], int s2[], int size);
    static int* remove(int s1[], int s2[], int size, int& retSize);
};

int* ArrayUtility2::concat(int s1[], int s2[], int size){
    int *temp = new int;
    for(int i=0; i< size; i++){
        temp[i] = s1[i];
    }
    for(int i=0; s2[i] != 0; i++){
        temp[size+i] = s2[i];
    }
    return temp;
}

int* ArrayUtility2::remove(int s1[], int s2[], int size, int& retSize){
    int* rmtot = new int [size/2];
    int cnt;
    for(int i=0; i<size/2; i++){
        cnt = 0;
        for(int j=0; j<size/2; j++){
            if(s1[i] == s2[j]) {
                cnt++;
            }
        }
        if(cnt == 0) {
            rmtot[i] = s1[i];
            retSize++;
        }
    }
    if(retSize == 0) return NULL;
    return rmtot;
}
int main(){
    int x[5], y[5];
    cout << "Type 5 number for array X >> ";
    for(int i=0; i<5; i++) cin >> x[i];
    cout << "Type 5 number for array Y >> ";
    for(int i=0; i<5; i++) cin >> y[i];
    int *assembled = ArrayUtility2::concat(x, y, 5);
    for(int i=0; i<5; i++) cout << assembled[i] << ' ';
    int counter;
    int *removed = ArrayUtility2::remove(x, y, 5, counter);
    cout << endl << "Result of removing Y from X, Number of resulting array is" << counter << endl;
    for(int i=0; i<counter; i++) cout << removed[i] << ' ';
    cout << endl;
}
