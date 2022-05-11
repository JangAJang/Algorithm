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

class MyQueue : public BaseArray{
    int size = 0;
public:
    MyQueue(int capacity){ setCapacity(capacity); }
    void enqueue(int n) { put(size, n); size++; }
    int capacity() { return getCapacity(); }
    int length(){return size; }
    int dequeue(){
        int res;
        res = get(0);
        for(int i=0; i<size-1; i++){
            put(i, get(i+1));
        }
        size--;
        return res;
    }
};

int main(){
    MyQueue mQ(100);
    int n;
    cout << "Type 5 numbers for the queue >> ";
    for(int i=0; i<5; i++){
        cin >> n;
        mQ.enqueue(n);
    }
    cout << " capacity of the Queue : " << mQ.capacity() << ", size of the Queue : " << mQ.length() << endl;
    cout << "Elements of the Queue is on the screen while eliminating on the queue >>";
    while(mQ.length()!=0){
        cout << mQ.dequeue() << ' ';
    }
    cout << endl << "Curent size of the Queue : " << mQ.length() << endl;
}
