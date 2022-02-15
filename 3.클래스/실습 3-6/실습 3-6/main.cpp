#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

class Random{
public:
    Random();
    int next();
    int nextInRange(int a, int b);
};

Random::Random(){
    
}

int Random::next(){
    srand((unsigned)time(NULL));
    return rand()/2*2;
}

int Random::nextInRange(int a, int b){
    srand((unsigned)time(NULL));
    return (rand()%(b-a+1) +a)/2*2;
}

int main(){
    Random r;
    cout << "--0에서 " << RAND_MAX <<"까지의 랜덤한 정수 10개 --"<< endl;
    for(int i=0; i<10; i++){
        int n = r.next();
        cout << n << ' ';
    }
    cout << endl << endl << "--2에서 10 까지의 랜덤 정수 10개--"<<endl;
    for(int i=0; i<10; i++){
        int n = r.nextInRange(2, 10);
        cout << n << ' ';
    }
    cout << endl;
}
