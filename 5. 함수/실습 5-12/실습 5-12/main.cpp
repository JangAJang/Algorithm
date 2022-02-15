#include <iostream>
using namespace std;

class Dept{
    int size;
    int* score;
public:
    Dept(int size){
        this->size = size;
        score = new int[size];
    }
    Dept(const Dept& dept);
    ~Dept();
    int getSize(){ return size; }
    void read();
    bool isOver60(int index);
};

Dept::Dept(const Dept& dept){
    this->size = dept.size;
    this->score = new int [size];
    for(int i=0; i < this->size; i++){
        this->score[i] = dept.score[i];
    }
}

Dept::~Dept(){
    delete [] score;
}

void Dept::read(){
    cout << "type down" << this->size << "numbers >> ";
    for(int i=0; i< this->size; i++){
        cin >> this->score[i];
    }
}

bool Dept::isOver60(int index){
    if(this->score[index] > 60) return true;
    else return false;
}

int countPass(Dept dept){
    int count = 0;
    for(int i = 0; i< dept.getSize(); i++){
        if(dept.isOver60(i)) count++;
    }
    return count;
}

int main(){
    Dept com(10);
    com.read();
    int n = countPass(com);
    cout << "there is" << n << "people who's over 60" << endl;
}
