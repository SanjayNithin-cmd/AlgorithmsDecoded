
def searchRange(nums, target):
    
    def binary_search(nums, target, searchLeft):
        left, right = 0, len(nums) - 1
        n = len(nums)
        index = None
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if searchLeft:
                    if mid-1 >= 0 and nums[mid-1] == target:
                        right -= 1
                    else:
                        return mid
                else:
                    if mid+1 < n and nums[mid+1] == target:
                        left += 1
                    else:
                        return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1 if not index else index 
    start_position = binary_search(nums, target, True)
    end_position = binary_search(nums, target, False)
    return [start_position, end_position]

print(searchRange([1,2,7,7,8,8,10], 8))