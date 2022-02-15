#include <iostream>
#include <cstring>
using namespace std;

class Trace{
public:
    static string function[100];
    static string status[100];
    static int counter;
    static void put(string function, string status);
    static void print(string function = "all");
};

int Trace::counter = 0;
string Trace::function[100];
string Trace::status[100];

void Trace::put(string fun, string sta){
    function[counter] = fun;
    status[counter] = sta;
    counter++;
}

void Trace::print(string fun){
    if(fun == "all"){
        for(int i=0; i< counter; i++){
            cout << function[i] << " : " << status[i] << endl;
        }
    }
    else{
        for(int i=0; i<counter; i++){
            if(fun == function[i]) cout << function[i] << " : " << status[i] << endl;
        }
    }
}

void f(){
    int a, b, c;
    cout << "Type two numbers >> ";
    cin >> a >> b;
    Trace::put("f()", "Numbers got");
    c = a + b;
    Trace::put("f()", "Added");
    cout << "sum is" << c << endl;
}

int main(){
    Trace::put("main()", "program started");
    f();
    Trace::put("main", "ended");
    Trace::print("f()");
    Trace::print();
}
