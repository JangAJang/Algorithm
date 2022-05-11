#include <iostream>
using namespace std;

class BaseMemory{
    char *mem;
protected:
    BaseMemory(int size = 0) { mem = new char [size]; }
    char getChar(int n) {return mem[n]; }
    void setMem(char *c) { mem = c; }
};

class ROM : public BaseMemory{
    int memory;
    int size;
public:
    ROM(int memory, char *c, int size);
    char read(int i){ return getChar(i); }
};

ROM::ROM(int memory, char *c, int size){
    this->memory = memory;
    this->size = size;
    setMem(c);
}

class RAM : public BaseMemory{
    int memory;
public:
    RAM(int memory) { this->memory = memory; }
    void write(int i, char n);
    char read(int i);
};

void RAM::write(int i, char n){
    char *c = new char [i+1];
    if(i == 0) c[i] = n;
    else{
        for(int j=0; j<i; j++){
            c[j] = getChar(j);
        }
        c[i] = n;
    }
    setMem(c);
}

char RAM::read(int i){
    return getChar(i);
}

int main(){
    char x[5] = {'h', 'e', 'l', 'l', 'o' };
    ROM biosROM(1024*10, x, 5);
    RAM mainMemory(1024*1024);
    for(int i=0; i<5; i++) mainMemory.write(i, biosROM.read(i));
    for(int i=0; i<5; i++) cout << mainMemory.read(i);
}
