n=int(input())
# 1에서부터 시작
# dp[n]=min(dp[n//3],dp[n//2],dp[n-1])+1
dp=[0]*(n+1)
for i in range(2,n+1):
    dp[i]=dp[i-1]+1
    if i%2==0:
        dp[i]=min(dp[i//2]+1,dp[i])
    if i%3==0:
        dp[i]=min(dp[i],dp[i//3]+1)

print(dp[n])