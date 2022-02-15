#include <iostream>

using namespace std;

int main(){
    int c=0, sum=0, price=0;
    char coffee[100];
    while(sum<20000){
    cout<<"에스프레소 2000원, 아메리카노 2300원, 카푸치노 2500원입니다.\n"<<"주문 >> ";
    cin>>coffee>>c;
        if(strcmp(coffee, "에스프레소")==0){
            price = c*2000;
            sum+=price;
            cout<<endl<<price<<"입니다. 맛있게 드세요.\n";
        }
        else if(strcmp(coffee, "아메키라노")==0){
            price = c*2300;
            sum+=price;
            cout<<endl<<price<<"입니다. 맛있게 드세요.\n";
        }
        else if(strcmp(coffee, "카푸치노")==0){
            price = c*2500;
            sum+=price;
            cout<<endl<<price<<"입니다. 맛있게 드세요.\n";
        }
    }
    return 0;
}
