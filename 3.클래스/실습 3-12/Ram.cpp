#include <iostream>
#include "Ram.h"
using namespace std;

char Ram::read(int address){
    return mem[address];
}

void Ram::write(int address, char value){
    mem[address] = value;
}

Ram::Ram(){}

Ram::~Ram(){
    cout << "메모리 제거됨" << endl;
}

