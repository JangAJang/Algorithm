#ifndef Exp_h
#define Exp_h

class Exp{
    int base, exp;
public:
    int result = 1;
    Exp();
    Exp(int a, int b);
    Exp(int c);
    int getValue();
    int getBase();
    int getExp();
    bool equals(Exp Exp);
};

Exp::Exp(){
    base = 1;
    exp = 1;
}

Exp::Exp(int a, int b){
    base = a;
    exp = b;
}

Exp::Exp(int c){
    base = c;
    exp = 1;
}

int Exp::getExp(){
    return exp;
}

int Exp::getBase(){
    return base;
}

int Exp::getValue(){
    int c;
    for(c=0; c< exp; c++){
        result *=base;
    }
    return result;
}

bool Exp::equals(Exp Exp){
    if(result == Exp.result) return true;
        else return false;
}
#endif /* Exp_h */
