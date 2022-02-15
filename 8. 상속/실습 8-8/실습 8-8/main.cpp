#include <iostream>
#include <cstring>
using namespace std;

class Laser{
    int at;
};

class Inkjet{
    int ai;
};

class Printer : protected Laser, protected Inkjet{
    string name, brand;
    int paper, print;
    
};
