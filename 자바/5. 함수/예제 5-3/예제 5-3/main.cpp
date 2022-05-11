#include <iostream>
using namespace std;

int main(){
    cout << "i" << '\t' << "n" << '\t' << "refn" << endl;
    int i=1, n=2;
    int &refn = n;
    n = 4;
    refn++;
    cout << i << '\t' << n << '\t' << refn << endl;
    refn = i;
    refn++;
    cout << i << '\t' << n << '\t' << refn << endl;
    int *p = &refn;
    *p = 20;
    cout << i << '\t' << n << '\t' << refn << endl;
    return 0;
}
