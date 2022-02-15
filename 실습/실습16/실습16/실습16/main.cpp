#include <iostream>
#include <cstring>

using namespace std;

char tolower(char t[10000]);
char isalpha(char t[10000], char tr[10000]);

int main(){
    char t[10000], tr[10000];
    cout<<"영문 텍스트를 입력하세요. 히스토그램을 그립니다."<<endl<<"텍스트의 끝은 ; 입니다. 10000개까지 가능합니다."<<endl;
    cin.getline(t, 10000, ';');
    return 0;
    tolower(t[10000]);
    isalpha(t[10000], tr[10000]);
    int c=0, count=0;
    for(c=0; c<10000;c++){
        if(t[c] != ' ') count++;
    }
    cout<<"총 알파벳 수 "<< count<<endl;
    
    for(c=0; c<10000;c++){              //a출력
        if(t[c] == 'a') count++;
    }
    cout<<endl<<"a" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //b출력
        if(t[c] == 'b') count++;
    }
    cout<<endl<<"b" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //c출력
        if(t[c] == 'c') count++;
    }
    cout<<endl<<"c" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //d출력
        if(t[c] == 'd') count++;
    }
    cout<<endl<<"d" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //e출력
        if(t[c] == 'e') count++;
    }
    cout<<endl<<"e" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //f출력
        if(t[c] == 'f') count++;
    }
    cout<<endl<<"f" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //g출력
        if(t[c] == 'g') count++;
    }
    cout<<endl<<"g" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //h출력
        if(t[c] == 'h') count++;
    }
    cout<<endl<<"h" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //i출력
        if(t[c] == 'i') count++;
    }
    cout<<endl<<"i" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //j출력
        if(t[c] == 'j') count++;
    }
    cout<<endl<<"j" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //k출력
        if(t[c] == 'k') count++;
    }
    cout<<endl<<"k" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //l출력
        if(t[c] == 'l') count++;
    }
    cout<<endl<<"l" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //m출력
        if(t[c] == 'm') count++;
    }
    cout<<endl<<"m" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //n출력
        if(t[c] == 'n') count++;
    }
    cout<<endl<<"n" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //o출력
        if(t[c] == 'o') count++;
    }
    cout<<endl<<"o" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //p출력
        if(t[c] == 'p') count++;
    }
    cout<<endl<<"p" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //q출력
        if(t[c] == 'q') count++;
    }
    cout<<endl<<"q" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //r출력
        if(t[c] == 'r') count++;
    }
    cout<<endl<<"r" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //s출력
        if(t[c] == 's') count++;
    }
    cout<<endl<<"s" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //t출력
        if(t[c] == 't') count++;
    }
    cout<<endl<<"t" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //u출력
        if(t[c] == 'u') count++;
    }
    cout<<endl<<"u" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //v출력
        if(t[c] == 'v') count++;
    }
    cout<<endl<<"v" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //w출력
        if(t[c] == 'w') count++;
    }
    cout<<endl<<"w" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //x출력
        if(t[c] == 'x') count++;
    }
    cout<<endl<<"x" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //a출력
        if(t[c] == 'y') count++;
    }
    cout<<endl<<"y" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    for(c=0; c<10000;c++){              //z출력
        if(t[c] == 'z') count++;
    }
    cout<<endl<<"z" <<"("<<count<<")"<< " : ";
    for(c=0; c<count;c++){
        cout<<"*";
    }
    cout<<endl;
    return 0;
}

char tolower(char t[10000]){
    int a;
    for(a=0; a<10000;a++){
        if(t[a] == 'A') t[a] = 'a';
        if(t[a] == 'B') t[a] = 'b';
        if(t[a] == 'C') t[a] = 'c';
        if(t[a] == 'D') t[a] = 'd';
        if(t[a] == 'E') t[a] = 'e';
        if(t[a] == 'F') t[a] = 'f';
        if(t[a] == 'G') t[a] = 'g';
        if(t[a] == 'H') t[a] = 'h';
        if(t[a] == 'I') t[a] = 'i';
        if(t[a] == 'J') t[a] = 'j';
        if(t[a] == 'K') t[a] = 'k';
        if(t[a] == 'L') t[a] = 'l';
        if(t[a] == 'M') t[a] = 'm';
        if(t[a] == 'N') t[a] = 'n';
        if(t[a] == 'O') t[a] = 'o';
        if(t[a] == 'P') t[a] = 'p';
        if(t[a] == 'Q') t[a] = 'q';
        if(t[a] == 'R') t[a] = 'r';
        if(t[a] == 'S') t[a] = 's';
        if(t[a] == 'T') t[a] = 't';
        if(t[a] == 'U') t[a] = 'u';
        if(t[a] == 'V') t[a] = 'v';
        if(t[a] == 'W') t[a] = 'w';
        if(t[a] == 'X') t[a] = 'x';
        if(t[a] == 'Y') t[a] = 'y';
        if(t[a] == 'Z') t[a] = 'z';
    }
    return t[10000];
}

char isalpha(char t[10000], char tr[10000]){
    int a, b;
    for(a=0, b=0; a+b<10000;a++){
        if(t[a] == 'a') tr[a] = t[a+b];
        if(t[a] == 'b') tr[a] = t[a+b];
        if(t[a] == 'c') tr[a] = t[a+b];
        if(t[a] == 'd') tr[a] = t[a+b];
        if(t[a] == 'e') tr[a] = t[a+b];
        if(t[a] == 'f') tr[a] = t[a+b];
        if(t[a] == 'g') tr[a] = t[a+b];
        if(t[a] == 'h') tr[a] = t[a+b];
        if(t[a] == 'i') tr[a] = t[a+b];
        if(t[a] == 'j') tr[a] = t[a+b];
        if(t[a] == 'k') tr[a] = t[a+b];
        if(t[a] == 'l') tr[a] = t[a+b];
        if(t[a] == 'm') tr[a] = t[a+b];
        if(t[a] == 'n') tr[a] = t[a+b];
        if(t[a] == 'o') tr[a] = t[a+b];
        if(t[a] == 'p') tr[a] = t[a+b];
        if(t[a] == 'q') tr[a] = t[a+b];
        if(t[a] == 'r') tr[a] = t[a+b];
        if(t[a] == 's') tr[a] = t[a+b];
        if(t[a] == 't') tr[a] = t[a+b];
        if(t[a] == 'u') tr[a] = t[a+b];
        if(t[a] == 'v') tr[a] = t[a+b];
        if(t[a] == 'w') tr[a] = t[a+b];
        if(t[a] == 'x') tr[a] = t[a+b];
        if(t[a] == 'y') tr[a] = t[a+b];
        if(t[a] == 'z') tr[a] = t[a+b];
        else b++;
    }
    return tr[10000];
}
