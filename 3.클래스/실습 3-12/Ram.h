#ifndef Ram_h
#define Ram_h

using namespace std;

class Ram{
    char mem[100*1024];
    int size;
public:
    Ram();
    ~Ram();
    char read(int address);
    void write(int address, char value);
};
#endif /* Ram_h */
