#include <iostrean>
using namespace std;

int main(){
    int a, b;
    for(a = 1; a<=9; a++){
        for(b = 1; b<=9; b++){
            cout<<b*a<<" ";
        }
        cout<<endl;
    }
}