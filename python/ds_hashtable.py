# Hash Tables
class HashTable:
    def __init__(self, asize=11):
        self.keyMap = [[] for _ in range(asize)]
        
    def hashFunc(self, key):
        total = 0
        ourprime = 31
        for ch in key:
            val = ord(ch) - 65
            total = (total*ourprime + val) % len(self.keyMap)
            
        return total
    
    def setter(self, key, value):
        idx = self.hashFunc(key)
        self.keyMap[idx].append([key, value])
        return idx
    
    def getter(self, key):
        idx = self.hashFunc(key)
        loc = self.keyMap[idx]
        if loc:
            for [k,v] in loc:
                if key == k:
                    return v
        else:
            return None
        
    def retKeys(self):
        allKeys = []
        for lsts in self.keyMap:
            if lsts:
                for lst in lsts:
                    if lst[0] not in allKeys:
                        allKeys.append(lst[0])
                
        return allKeys
    
    def retVals(self):
        allVals = []
        for lsts in self.keyMap:
            if lsts:
                for lst in lsts:
                    if lst[1] not in allVals:
                        allVals.append(lst[1])
                
        return allVals

# Driver code
ht = HashTable()
print(ht.setter('adios', 'goodbye'))
print(ht.setter('hola', 'hello'))

print(ht.keyMap)
print(ht.getter('hola'))
print(ht.getter('adios'))
print(ht.getter('ciao'))

print('Print keys:')
print(ht.retKeys())
print('Print values:')
print(ht.retVals())
