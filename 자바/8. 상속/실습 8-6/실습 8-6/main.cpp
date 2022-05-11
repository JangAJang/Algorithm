#include <iostream>
using namespace std;

class BaseArray{
private:
    int capacity;
    int *mem;
protected:
    BaseArray(int capacity = 100){
        this->capacity = capacity; mem = new int [capacity];
    }
    ~BaseArray(){delete [] mem;}
    void put(int index, int val) { mem[index] = val;}
    int get(int index) {return mem[index];}
    int getCapacity() { return capacity; }
    void setCapacity(int capacity) { this->capacity = capacity; }
};

class MyStack : public BaseArray{
    int size = 0;
public:
    MyStack(int capacity) { setCapacity(capacity); }
    void push(int n){put(size, n); size++;}
    int capacity(){return getCapacity();}
    int length(){return size;}
    int pop(){
        int res = get(size-1);
        put(size-1, 0);
        size--;
        return res;
    }
};

int main(){
    MyStack mStack(100);
    int n;
    cout << "Insert 5 numbers in stack >> ";
    for(int i=0; i<5; i++){
        cin >> n;
        mStack.push(n);
    }
    cout << "Capacity of the stack : " << mStack.capacity() << ", Size of the stack : " << mStack.length() << endl;
    cout << "Pop all the elements from the stack >> ";
    while(mStack.length() != 0){
        cout << mStack.pop() << ' ';
    }
    cout << endl << "Stack's current size : " << mStack.length() << endl;
}
