class Solution:
    def complexNumberMultiply(self, a: str, b: str) -> str:
        real_a = int(a.split('+')[0])
        img_a = int(a.split('+')[1][:-1])
        
        real_b = int(b.split('+')[0])
        img_b = int(b.split('+')[1][:-1])
        
        real_soln = real_a * real_b - (img_a * img_b)
        img_soln = real_a * img_b + img_a * real_b
        return (f'{real_soln}+{img_soln}i')
