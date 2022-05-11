#include <iostream>
#include <string>
using namespace std;

class Histogram{
    string histogram;
    int size;
public:
    Histogram(string histogram);
    void print();
    string put(string words);
    string putc(string c);
};

Histogram::Histogram(string histogram){
    this->histogram = histogram;
    cout << histogram << endl;
}


string Histogram::put(string words){
    histogram.append(words);
    return words;
}

string Histogram::putc(string c){
    histogram.append(c);
    return c;
}

void Histogram::print(){
    int counter = 0;
    for(int i=0; i<this->histogram.length(); i++){
        if(histogram[i] >= 65 && histogram[i] <= 90){
            histogram[i] += 32;
        }
    }
    for(int i=0; i<this->histogram.length(); i++){
        if(histogram[i] >= 97 && histogram[i] <= 122){
            counter++;
        }
    }
    this->size = counter;
    cout << "총 알파벳 수 " << this->size << endl << endl;
    char alphabet = 'a';
    for(int i=0; i < 26; i++){
        int alphabetCounter = 0;
        for(int j = 0; j< histogram.length(); j++){
            if(histogram[j] == alphabet){
                alphabetCounter++;
            }
        }
        cout << alphabet << " (" << alphabetCounter << ")   : ";
        for(int k=0; k<alphabetCounter; k++){
            cout << "*";
        }
        cout << endl;
        alphabet++;
    }
}

int main(){
    Histogram elvisHisto("Wise men say, only fools rush in But I can't help, ");
    elvisHisto.put("falling in love with you");
    elvisHisto.putc("-");
    elvisHisto.put("Elvis Presley");
    elvisHisto.print();
    return 0;
}
