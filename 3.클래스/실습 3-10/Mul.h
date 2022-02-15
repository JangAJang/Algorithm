#ifndef Mul_h
#define Mul_h
class Mul{
    int a, b;
public:
    Mul();
    void setValue(int x, int y);
    int calculate();
};

Mul::Mul(){}

void Mul::setValue(int x, int y){
    a = x;
    b = y;
}

int Mul::calculate() {
    return a*b;
}

#endif /* Mul_h */
