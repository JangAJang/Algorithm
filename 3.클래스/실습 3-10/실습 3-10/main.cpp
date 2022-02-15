#include <iostream>
#include "Add.h"
#include "Sub.h"
#include "Mul.h"
#include "Div.h"

using namespace std;

int main(){
    int x, y;
    Add a;
    Sub s;
    Mul m;
    Div d;
    char cal;
    while (true) {
        cout << "두 정수와 연산자를 입력하세요 >> ";
        cin >> x >> y >> cal;
        if(cal == '+'){
            a.setValue(x, y);
            cout << a.calculate() << endl;
        }
        else if(cal == '-'){
            s.setValue(x, y);
            cout << s.calculate() << endl;
        }
        else if(cal == '*'){
            m.setValue(x, y);
            cout << m.calculate() << endl;
        }
        else if(cal == '/'){
            d.setValue(x, y);
            cout << d.calculate() << endl;
        }
        else cout << "!!!!!error!!!!!" << endl;
    }
}
