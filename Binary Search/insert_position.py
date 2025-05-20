
def searchInsert(nums, target):
    left, right = 0, len(nums) - 1
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            right -= 1
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return right+1

print(searchInsert([1,2,3,5,5,7,8], 5))