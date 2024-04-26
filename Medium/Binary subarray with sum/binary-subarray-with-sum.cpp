//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
  public:
    int fun(vector<int>& nums, int goal){
        if(goal<0) return 0;
        int j=0,ans=0,sum=0;

        for(int i=0;i<nums.size();i++){
            sum+=nums[i];

            while(sum>goal){
                sum-=nums[j];
                j++;
            }

            ans+=(i-j+1);

        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& arr, int N, int target){
        return fun(arr,target)-fun(arr,target-1);

    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin >> N;
        int target; 
        cin >> target;
        vector<int> arr(N);
        for(int i=0; i<N; i++)
            cin >> arr[i];
        Solution obj;
        cout<<obj.numberOfSubarrays(arr, N, target)<<endl;
    }
    return 0;
}
// } Driver Code Ends