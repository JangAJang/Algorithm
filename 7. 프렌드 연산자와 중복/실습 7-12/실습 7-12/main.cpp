#include <iostream>
using namespace std;

class SortedArray{
    int *p, size;
    void sort();
public:
    SortedArray(){ size = 0; p=NULL;}
    SortedArray(SortedArray& src);
    SortedArray(int p[], int size);
    ~SortedArray(){};
    SortedArray operator +(SortedArray& op2);
    SortedArray& operator =(const SortedArray& op2);
    void show();
};

void SortedArray::sort(){
    int x = 0, check = 0;
    int *tmp = new int [size];
    while(true){
        for(int i=0; i<size; i++){
            if(p[i] == x) {tmp[check] = p[i]; check ++;}
        }
        x++;
        if(check == size) break;
    }
    for(int i=0; i<size; i++){
        p[i] = tmp[i];
    }
}

SortedArray::SortedArray(SortedArray& src){
    this->size = src.size;
    this->p = src.p;
    sort();
}

SortedArray::SortedArray(int p[], int size){
    this->size = size;
    this->p = new int [size];
    for(int i=0; i<size; i++){
        this->p[i] = p[i];
    }
    sort();
}

SortedArray SortedArray::operator+(SortedArray& op2){
    SortedArray copy(*this);
    copy.size += op2.size;
    copy.p = new int [copy.size];
    for(int i=0; i<this->size; i++){
        copy.p[i] = this->p[i];
    }
    for(int i=0; i<op2.size; i++){
        copy.p[this->size+i] = op2.p[i];
    }
    copy.sort();
    return copy;
}

SortedArray& SortedArray::operator=(const SortedArray& op2){
    this->size = op2.size;
    delete [] this->p;
    this->p = op2.p;
    return *this;
}

void SortedArray::show(){
    cout << "배열 출력 : ";
    for(int i=0; i<size; i++){
        cout << p[i] << ' ';
    }
    cout << endl;
}

int main(){
    int n[] = {2, 20, 6};
    int m[]= {10, 7, 8, 30};
    SortedArray a(n, 3), b(m, 4), c;
    c = a+b;
    a.show();
    b.show();
    c.show();
}
