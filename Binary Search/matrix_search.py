def searchMatrix( matrix, target: int):
    def binary_search_row(matrix, target):
            left, right = 0, len(matrix) - 1
            while left <= right:
                mid = (left + right) // 2
                if matrix[mid][0] <= target:
                    if mid + 1 < len(matrix) and matrix[mid+1][0] <= target:
                        left = mid + 1
                    else: 
                        return mid
                else:
                    right = mid - 1
            return None
    def binary_search_col(row, target):
        left, right = 0, len(row)-1
        while left <= right:
            mid = (left + right) // 2
            if row[mid] == target:
                return mid
            elif row[mid] < target:
                left = mid + 1
            else:
                right = mid -1
        return None
    row_index = binary_search_row(matrix, target)
    if row_index != None:
        result = binary_search_col(matrix[row_index], target)
        return True if result != None else False
    else:
        return False
    
print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3))