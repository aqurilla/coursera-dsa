# Generate fibonacci
def fib(n, memo):
    if memo[n] != None:
        return memo[n]
    if n<=2: return 1
    res = fib(n-1, memo) + fib(n-2, memo)
    memo[n] = res
    return res

n = 100
memo = [None for _ in range(n+1)]
print(fib(n, memo))
