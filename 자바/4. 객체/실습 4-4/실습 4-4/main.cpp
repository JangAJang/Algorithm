#include <iostream>

using namespace std;

class Sample{
    int *p;
    int size;
public:
    Sample(int n){
        size = n;
        p = new int [n];
    }
    void read();
    void write();
    int big();
    ~Sample(){ delete []p;};
};

void Sample::read(){
    cout << "10개의 수를 입력하시오. " << endl;
    for(int i = 0; i<size; i++){
        cin >> p[i];
    }
}

void Sample::write(){
    for(int i = 0; i<size; i++){
        cout << p[i] << ' ';
    }
    cout << endl;
}

int Sample::big(){
    int biggest = p[0];
    for(int i=0; i<size; i++){
        if(biggest < p[i]) biggest = p[i];
    }
    return biggest;
}

int main(){
    Sample s(10);
    s.read();
    s.write();
    cout << "가장 큰 수는 " << s.big() << endl;
    return 0;
}
