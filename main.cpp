#include<iostream>
using namespace std;
void solve(){
    int n,count=0;
    string s;
    cin>>n>>s;
    for(int i=0;i<5;i++){
        if(s[i]=='T'){
            count++;
            break;
        }
    }
    for(int i=0;i<5;i++){
        if(s[i]=='i'){
            count++;
            break;
        }
    }
    for(int i=0;i<5;i++){
        if(s[i]=='m'){
            count++;
            break;
        }
    }
    for(int i=0;i<5;i++){
        if(s[i]=='u'){
            count++;
            break;
        }
    }
    for(int i=0;i<5;i++){
        if(s[i]=='r'){
            count++;
            break;
        }
    }
    if(count==5 && n==5){
        cout<<"YES"<<endl;
    }
    else{
        cout<<"NO"<<endl;
    }
}
int main(){
    int t;
    cin>>t;
    while(t--){
        solve();
    }
    return 0;
}