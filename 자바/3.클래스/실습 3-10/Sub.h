#ifndef Sub_h
#define Sub_h
class Sub{
    int a, b;
public:
    Sub();
    void setValue(int x, int y);
    int calculate();
};

Sub::Sub(){}

void Sub::setValue(int x, int y){
    a = x;
    b = y;
}

int Sub::calculate() {
    return a-b;
}

#endif /* Sub_h */
