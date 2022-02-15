#include <iostream>
#include <cstring>
using namespace std;

class Buffer{
    string text;
public:
    Buffer(string text) { this->text = text; }
    void add(string next) {text += next; }
    void print() {cout << text << endl;}
};

Buffer& append(Buffer& buff, string added){
    buff.add(added);
    return buff;
}

int main(){
    Buffer buff("Hello");
    Buffer &temp = append(buff, "Guys");
    temp.print();
    buff.print();
}
