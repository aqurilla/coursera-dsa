# https://leetcode.com/problems/beautiful-array/

class Solution:
    def beautifulize(self, Nlist):
        if len(Nlist)>1:
            m = len(Nlist)//2

            left = Nlist[:m]
            right = Nlist[m:]

            self.beautifulize(left)
            self.beautifulize(right)

            i = 0
            j = len(Nlist)-1

            k = 0
            while k<len(left):
                if left[k]%2==1:
                    Nlist[i] = left[k]
                    i+=1
                    k+=1
                else:
                    Nlist[j] = left[k]
                    j-=1
                    k+=1

            k = 0
            while k<len(right):
                if right[k]%2==1:
                    Nlist[i] = right[k]
                    i+=1
                    k+=1
                else:
                    Nlist[j] = right[k]
                    j-=1
                    k+=1


    def beautifulArray(self, N: int) -> List[int]:
        Nlist = list(range(1, N+1))
        self.beautifulize(Nlist)

        return Nlist
