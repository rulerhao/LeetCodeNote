class NumberContainers:
    def __init__(self):
        self.index_val = {}  
        self.val_index = {}  
    def change(self, index: int, number: int) -> None:
        self.index_val[index] = number
        
        if number not in self.val_index:
            self.val_index[number] = []
        heappush(self.val_index[number], index)

    def find(self, number: int) -> int:
        if number not in self.val_index:
            return -1
        
        while self.val_index[number] and self.index_val[self.val_index[number][0]] != number:
            heappop(self.val_index[number])

        return self.val_index[number][0] if self.val_index[number] else -1
