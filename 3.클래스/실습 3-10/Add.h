#ifndef Add_h
#define Add_h
class Add{
    int a, b;
public:
    Add();
    void setValue(int x, int y);
    int calculate();
};
Add::Add(){}

void Add::setValue(int x, int y){
    a = x;
    b = y;
}

int Add::calculate() {
    return a+b;
}

#endif /* Add_h */
