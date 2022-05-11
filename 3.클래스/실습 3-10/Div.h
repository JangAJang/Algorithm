#ifndef Div_h
#define Div_h
class Div{
    int a, b;
public:
    Div();
    void setValue(int x, int y);
    int calculate();
};
Div::Div(){}

void Div::setValue(int x, int y){
    a = x;
    b = y;
}

int Div::calculate() {
    return a / b;
}

#endif /* Div_h */
