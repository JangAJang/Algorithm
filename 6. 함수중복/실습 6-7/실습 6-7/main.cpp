#include <iostream>
#include <cstdlib>
#include <cmath>
using namespace std;

class Random{
public:
    static void seed() {srand((unsigned)time(0));}
    static int nextInt(int min = 0, int max = 32767);
    static char nextAlphabet();
    static double nextDouble();
};

int Random::nextInt(int min, int max){
    int x = rand() % (max-min) + min;
    return x;
}

char Random::nextAlphabet(){
    char alpha;
    if(rand()%2 == 0) alpha = nextInt(65, 90);
    else alpha = nextInt(97, 122);
    return alpha;
}

double Random::nextDouble(){
    double y = rand();
    while(y > 1){
        y /= 10;
    }
    return y;
}

int main(){
    cout << "Show 10 numbers bigger than 1 and smaller than 100" << endl;
    for(int i=0; i<10; i++){
        cout << Random::nextInt(1, 100) << ' ';
    }
    cout << endl << "Show 10 alphabets " << endl;
    for(int i=0; i<10; i++){
        cout << Random::nextAlphabet() << ' ';
    }
    cout << endl << "Show 10 numbers between 0 and 1" << endl;
    for(int i=0; i<5; i++){
        cout << Random::nextDouble() << ' ';
    }
    cout << endl;
    for(int i=0; i<5; i++){
        cout << Random::nextDouble() << ' ';
    }
}
