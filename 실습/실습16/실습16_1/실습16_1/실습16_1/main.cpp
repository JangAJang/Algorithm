#include <iostream>
#include <cstring>

using namespace std;

int main(){
    char t[10000];
    cout<<"영문 텍스트를 입력합니다. 히스토그램을 그립니다.\n텍스트의 끝은 ; 입니다. 10000개까지 가능합니다.\n";
    cin.getline(t, 10000, ';');
    int a;
    for(a=0; a<10000;a++){
        t[a] = tolower(t[a]);
    }
    int b=0;
    for(a=0; a<10000;a++){
        if(isalpha(t[a]) == 2) b++;
    }
    cout<<"총 알파벳 수 "<<b<<endl<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'a') b++; //a
    cout<<"a ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'b') b++; //b
    cout<<"b ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'c') b++; //c
    cout<<"c ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'd') b++; //d
    cout<<"d ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'e') b++; //e
    cout<<"e ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'f') b++; //f
    cout<<"f ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'g') b++; //g
    cout<<"g ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'h') b++; //h
    cout<<"h ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'i') b++; //i
    cout<<"i ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'j') b++; //j
    cout<<"j ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'k') b++; //k
    cout<<"k ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'l') b++; //l
    cout<<"l ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'm') b++; //m
    cout<<"n ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'n') b++; //n
    cout<<"n ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'o') b++; //o
    cout<<"o ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'p') b++; //p
    cout<<"p ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'q') b++; //q
    cout<<"q ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'r') b++; //r
    cout<<"r ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 's') b++; //s
    cout<<"s ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 't') b++; //t
    cout<<"t ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'u') b++; //u
    cout<<"u ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'v') b++; //v
    cout<<"v ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'w') b++; //w
    cout<<"w ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'x') b++; //x
    cout<<"x ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'y') b++; //y
    cout<<"y ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    for(a=0, b=0; a<10000;a++) if(t[a] == 'z') b++; //z
    cout<<"z ("<<b<<")  : ";
    for(a=0; a<b; a++) cout<<"*";
    cout<<endl;
    return 0;
}
