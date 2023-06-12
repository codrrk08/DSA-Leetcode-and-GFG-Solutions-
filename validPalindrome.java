class Solution {
public:
    bool isPalindrome(string s) {

        string a="";
        char g;
        if(s.length()==0)
        return true;
        int i=0;
        while(i<s.length())
        {
            if (isalnum(s[i]))
            {
                g = tolower(s[i]);
                a = a + g;
            }
            i++;
        }
        string c="";
        string b="";
        int j = a.length()-1;
        while(j>=0)
        {
            c= a.substr(j-1,j));
            b=b + c;
        }
        if(b==a)
        return true;
        else
        return false;

    
    }
};
